package org.demo.crpyt.key.asymmetric.handler;

import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.misc.NetscapeCertType;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.X509KeyUsage;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.demo.crpyt.entity.CertificateEntity;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.handler.AbstractKey;
import org.wys.demo.common.exception.CryptException;

import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
public abstract class AsymmetricKeyHandler extends AbstractKey implements AsymmetricHandler, CertificateHandler {


    /**
     * 这里C是国家和地区代码,S和L都是地区代码,S相当于省或者州这样的级别,L相当于城市级别,O是组织机构名称,OU是次级组织机构名称,CN是主体的 通用名(common name).
     * 在这里,C,S,L等等属性的类型都是相对固定的,例如C一般就是用来表示国家和地区代码,在DN结构中还可以添加一些其它类型的信息,一般 也都是以"xxx=xxx"这样来表示的.
     */
    protected Signature signature;
    protected static final String SIGNATURE_HEAD = "Signature_";

    /**
     * 生成密钥对
     *
     * @return 密钥对
     */
    protected abstract KeyPair generateKeyPair();

    public AsymmetricKeyHandler() {

    }

    public AsymmetricKeyHandler(String constant) {
        super(constant);
    }

    /**
     * 初始化签名算法
     *
     * @param algorithm 签名算法
     */
    protected void initSignature(String algorithm) {
        try {
            signature = Signature.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e);
        }
    }

    /**
     * 私钥加密，公钥解密
     *
     * @param entity 需要签名的数据
     * @return 加密之后结果
     */
    @Override
    public KeyEntity sign(KeyEntity entity) {
        try {
            //初始化签名算法
            initSignature(entity.getSignAlgorithm());
            //初始化私钥状态
            signature.initSign(entity.getPrivateKey());
            //更新数据
            signature.update(entity.getData());
            //签名
            byte[] signData = signature.sign();
            entity.setSummaryMessage(signData);
        } catch (InvalidKeyException | SignatureException e) {
            throw new CryptException(e);
        }
        return entity;
    }

    public PublicKey generatePublicKey(byte[] key) {

        //通过X509规范解析公钥
        //生成DH公钥
        PublicKey publicKey;
        //生成新的公钥
        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key);
            KeyFactory keyFactory = KeyFactory.getInstance(getAlgorithm());
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return publicKey;
    }

    @Override
    public boolean verifySign(KeyEntity entity) {
        boolean bool;
        try {
            //验签
            signature.initVerify(entity.getPublicKey());
            signature.update(entity.getData());
            //验签结果
            bool = signature.verify(entity.getSummaryMessage());
        } catch (SignatureException | InvalidKeyException e) {
            throw new CryptException(e);
        }
        return bool;
    }


    /**
     * 通用证书签发逻辑
     * 1、构建证书参数
     * 2、组装证书
     * 3、返回生成的证书
     *
     * @param rootEntity 根实体
     * @param subEntity  子实体
     * @param isUser     是否是用户
     * @return 证书信息
     */
    protected KeyEntity commonIssuingCertificate(KeyEntity rootEntity, KeyEntity subEntity, boolean isUser) {
        //如果有根证书，则需要将根证书私钥，否则是对本身做处理，用自己的私钥
        //密钥
        PublicKey publicKey = subEntity.getPublicKey();
        PrivateKey privateKey = subEntity.getPrivateKey();
        X500Name subject = subEntity.getCertificate().getSubject();
        PublicKey rootKey = subEntity.getPublicKey();
        if (Objects.nonNull(rootEntity) && Objects.nonNull(rootEntity.getPrivateKey())) {
            rootKey = rootEntity.getPublicKey();
            privateKey = rootEntity.getPrivateKey();
            subject = rootEntity.getCertificate().getSubject();
        }
        CertificateEntity subCertificate = subEntity.getCertificate();
        //构造JCA证书
        JcaX509v3CertificateBuilder certificateBuilder = new JcaX509v3CertificateBuilder(
                subject,
                subCertificate.getSerialNumber(),
                subCertificate.getStartDate(),
                subCertificate.getEndDate(),
                subCertificate.getSubject(),
                publicKey);
        JcaContentSignerBuilder contentSignerBuilder = new JcaContentSignerBuilder(subEntity.getSignAlgorithm());
        try {
            ContentSigner contentSigner = contentSignerBuilder.build(privateKey);
            //签名证书
            JcaX509ExtensionUtils etsUtils = new JcaX509ExtensionUtils();
            certificateBuilder.addExtension(Extension.keyUsage, false,
                    new X509KeyUsage(X509KeyUsage.digitalSignature | X509KeyUsage.nonRepudiation));
            certificateBuilder.addExtension(Extension.authorityKeyIdentifier, false, etsUtils.createAuthorityKeyIdentifier(rootKey));
            certificateBuilder.addExtension(Extension.subjectKeyIdentifier, false, etsUtils.createSubjectKeyIdentifier(publicKey));
            certificateBuilder.addExtension(Extension.basicConstraints, false, new BasicConstraints(!isUser));
            certificateBuilder.addExtension(MiscObjectIdentifiers.netscapeCertType, false,
                    new NetscapeCertType(NetscapeCertType.sslClient));
            //证书编码
            X509Certificate x509Certificate = new JcaX509CertificateConverter().getCertificate(certificateBuilder.build(contentSigner));
            subCertificate.setCertificate(x509Certificate);
        } catch (OperatorCreationException | CertificateException | NoSuchAlgorithmException | CertIOException e) {
            throw new RuntimeException(e);
        }
        return subEntity;
    }

    @Override
    public KeyEntity issuingRootCertificate(KeyEntity entity) {
        return entity;
    }

    @Override
    public KeyEntity issuingSubCertificate(KeyEntity rootEntity, KeyEntity subEntity) {
        return subEntity;
    }

    @Override
    public KeyEntity issuingUserCertificate(KeyEntity rootEntity, KeyEntity userEntity) {
        return userEntity;
    }
}
