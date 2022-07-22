package org.demo.crpyt.key.asymmetric.bc;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.demo.crpyt.certificate.CertificateUtil;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.CipherConstant;
import org.demo.crpyt.constant.SignatureConstant;
import org.demo.crpyt.entity.CertificateEntity;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.asymmetric.AsymmetricUtil;
import org.demo.crpyt.key.asymmetric.handler.AsymmetricKeyHandler;
import org.wys.demo.common.exception.CryptException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author wys
 * @date 2022/07/13
 * @desc RSA具体算法实现类
 */
@Slf4j
public class RsaBcStrategy extends AsymmetricKeyHandler {

    private static final int SIMPLE = 1024;
    private static final int MIDDLE = 2048;


    public RsaBcStrategy() {
        super(CipherConstant.RSA);
    }

    @Override
    public KeyEntity encrypt(String data) {
        KeyEntity key = new KeyEntity();
        try {
            //生成公钥和私钥
            KeyPair keyPair = generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();
            //初始化加密
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //加密
            byte[] res = cipher.doFinal(data.getBytes());
            //组装数据
            key.setPublicKey(publicKey);
            key.setPrivateKey(privateKey);
            key.setData(res);
            key.setAlgorithm(getAlgorithm());
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptException(e);
        }
        return key;
    }

    /**
     * 重载，对已有的数据重新进行加密
     *
     * @param key key实体类
     * @return 加密后的数据
     */
    public KeyEntity encrypt(KeyEntity key) {
        try {
            PrivateKey privateKey = key.getPrivateKey();
            PublicKey publicKey = key.getPublicKey();
            //初始化加密
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            //加密
            byte[] res = cipher.doFinal(key.getData());
            //组装数据
            key.setPublicKey(publicKey);
            key.setPrivateKey(privateKey);
            key.setData(res);
            key.setAlgorithm(getAlgorithm());
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptException(e);
        }
        return key;
    }

    @Override
    public String decrypt(KeyEntity entity) {
        String decryptData;
        try {
            cipher.init(Cipher.DECRYPT_MODE, entity.getPrivateKey());
            byte[] decryptBytes = cipher.doFinal(entity.getData());
            decryptData = new String(decryptBytes, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptException(e);
        }
        return decryptData;
    }

    @Override
    protected KeyPair generateKeyPair() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(getAlgorithm());
            keyPairGenerator.initialize(MIDDLE);
            keyPair = keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e);
        }
        return keyPair;
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.RSA;
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
            //采用PKCS8结构序列 生成私钥
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(entity.getPrivateKey().getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance(getAlgorithm());
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            entity.setPrivateKey(privateKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CryptException(e);
        }
        return super.sign(entity);
    }

    @Override
    public boolean verifySign(KeyEntity entity) {
        try {
            //公钥
            PublicKey publicKey = entity.getPublicKey();
            //证书
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
            //生成新的公钥
            KeyFactory keyFactory = KeyFactory.getInstance(getAlgorithm());
            publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            //验签
            entity.setPublicKey(publicKey);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new CryptException(e);
        }
        return super.verifySign(entity);
    }

//    /**
//     * 根证书
//     * 颁发证书就是整体定义证书结构，然后把参数填入进去，转换成证书格式就好
//     *
//     * @param entity 签发证书
//     * @return 封装好的证书的实体类
//     */
//    public KeyEntity v3tIssuingRootCertificate(KeyEntity entity) {
//        KeyEntity messageEntity = new KeyEntity();
//        ModelUtil.copyProperties(entity, messageEntity);
//        //证书结构
//        ASN1Integer serialNumber = new ASN1Integer(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
//        SubjectPublicKeyInfo publicKeyInfo = SubjectPublicKeyInfo.getInstance(entity.getPublicKey().getEncoded());
//        AlgorithmIdentifier identifier = new AlgorithmIdentifier(new ASN1ObjectIdentifier(AsymmetricUtil.getOid(SIGNATURE_HEAD + SignatureConstant.SHA256_WITH_RSA)));
//        V3TBSCertificateGenerator tbsCertificateGenerator = new V3TBSCertificateGenerator();
//        X500Name name = new X500Name(ISSUER);
//        //组装证书
//        tbsCertificateGenerator.setSerialNumber(serialNumber);
//        tbsCertificateGenerator.setSignature(identifier);
//        tbsCertificateGenerator.setIssuer(name);
//        tbsCertificateGenerator.setStartDate(new ASN1UTCTime(new Date()));
//        tbsCertificateGenerator.setEndDate(new ASN1UTCTime(new Date()));
//        tbsCertificateGenerator.setSubject(name);
//        tbsCertificateGenerator.setSubjectPublicKeyInfo(publicKeyInfo);
//        tbsCertificateGenerator.setSubjectUniqueID(new DERBitString((ISSUER).getBytes()));
//        tbsCertificateGenerator.setIssuerUniqueID(new DERBitString((ISSUER).getBytes()));
//        //生成TBS证书
//        TBSCertificate tbsCertificate = tbsCertificateGenerator.generateTBSCertificate();
//        //转换成ASN1编码格式,必须严格按照 证书 -> 算法OID -> 摘要格式进行填充，否则报错
//        ASN1EncodableVector v = new ASN1EncodableVector();
//        v.add(tbsCertificate);
//        v.add(identifier);
//        v.add(new DERBitString(entity.getSummaryMessage()));
////        entity.setCertificate(Certificate.getInstance(new DERSequence(v)));
//        return entity;
//    }

    @Override
    public KeyEntity issuingRootCertificate(KeyEntity entity) {
        return commonIssuingCertificate(null, entity, false);
    }

    @Override
    public KeyEntity issuingSubCertificate(KeyEntity rootEntity, KeyEntity subEntity) {
        return commonIssuingCertificate(rootEntity, subEntity, false);
    }

    @Override
    public KeyEntity issuingUserCertificate(KeyEntity rootEntity, KeyEntity userEntity) {
        return commonIssuingCertificate(rootEntity, userEntity, true);
    }

    /**
     * Mock参数
     *
     * @return mock证书信息
     */
    public static CertificateEntity mock() {
        //开始时间 & 结束时间
        Date start = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate plusDays = LocalDate.now().plusDays(2);
        ZonedDateTime zdt = plusDays.atStartOfDay(zoneId);
        Date end = Date.from(zdt.toInstant());
        String oid = AsymmetricUtil.getOid(SIGNATURE_HEAD + SignatureConstant.SHA256_WITH_RSA);
        ASN1ObjectIdentifier asn1ObjectIdentifier = new ASN1ObjectIdentifier(oid);
        AlgorithmIdentifier identifier = new AlgorithmIdentifier(asn1ObjectIdentifier);
        CertificateEntity entity = new CertificateEntity();
        entity.setCertificate(null);
        entity.setSerialNumber(BigInteger.valueOf(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE));
        entity.setSignature(identifier);
        entity.setIssuer(new X500Name(CertificateUtil.getName()));
        entity.setStartDate(start);
        entity.setEndDate(end);
        entity.setSubject(new X500Name(CertificateUtil.getName()));
        try {
            entity.setIssuerUniqueId(new DERBitString(entity.getIssuer().getEncoded()));
            entity.setSubjectUniqueId(new DERBitString(entity.getSubject().getEncoded()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }
}
