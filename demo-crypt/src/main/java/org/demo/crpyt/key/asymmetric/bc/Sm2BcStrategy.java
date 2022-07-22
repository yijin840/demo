package org.demo.crpyt.key.asymmetric.bc;


import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.gm.GMNamedCurves;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPrivateKey;
import org.bouncycastle.jcajce.provider.asymmetric.ec.BCECPublicKey;
import org.bouncycastle.math.ec.ECPoint;
import org.demo.crpyt.certificate.CertificateUtil;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.CipherConstant;
import org.demo.crpyt.constant.SpecConstant;
import org.demo.crpyt.entity.CertificateEntity;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.asymmetric.handler.AsymmetricKeyHandler;
import org.wys.demo.common.exception.CryptException;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.jce.spec.ECParameterSpec;
import org.bouncycastle.jce.spec.ECPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
@Slf4j
public class Sm2BcStrategy extends AsymmetricKeyHandler {


    public Sm2BcStrategy() {
        super(CipherConstant.SM2);
    }

    @Override
    public KeyEntity encrypt(String data) {
        KeyEntity entity = new KeyEntity();
        //生成公钥&私钥
        KeyPair keyPair = generateKeyPair();
        BCECPublicKey publicKey = (BCECPublicKey) keyPair.getPublic();
        BCECPrivateKey privateKey = (BCECPrivateKey) keyPair.getPrivate();
        //加密
        X9ECParameters parameters = GMNamedCurves.getByName(SpecConstant.SM2);
        ECParameterSpec ecParameterSpec = new ECParameterSpec(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH());
        ECPoint ecPoint = parameters.getCurve().decodePoint(publicKey.getQ().getEncoded(true));
        try {
            //密钥工厂进行生成EC公钥
            KeyFactory keyFactory = KeyFactory.getInstance(AlgorithmConstant.EC, PROVIDER);
            BCECPublicKey manualPublicKey = (BCECPublicKey) keyFactory.generatePublic(new ECPublicKeySpec(ecPoint, ecParameterSpec));
            //加密
            cipher.init(Cipher.ENCRYPT_MODE, manualPublicKey);
            byte[] encryptData = cipher.doFinal(data.getBytes());
            //组装数据
            entity.setAlgorithm(getAlgorithm());
            entity.setData(encryptData);
            entity.setPublicKey(publicKey);
            entity.setPrivateKey(privateKey);
        } catch (IllegalBlockSizeException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException |
                 InvalidKeyException e) {
            throw new CryptException(e);
        }
        return entity;
    }

    @Override
    public String decrypt(KeyEntity entity) {
        String res;
        try {
            cipher.init(Cipher.DECRYPT_MODE, entity.getPrivateKey());
            byte[] decryptData = cipher.doFinal(entity.getData());
            res = new String(decryptData);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException e) {
            throw new CryptException(e);
        }
        return res;
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.SM2;
    }

    @Override
    protected KeyPair generateKeyPair() {
        //从曲线上获取公钥和私钥
        AlgorithmParameterSpec sm2Spec = new ECGenParameterSpec(SpecConstant.SM2);
        KeyPair keyPair;
        try {
            //随机数
            SecureRandom random = new SecureRandom();
            //椭圆曲线公钥&私钥生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(AlgorithmConstant.EC, PROVIDER);
            keyPairGenerator.initialize(sm2Spec, random);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            throw new CryptException(e);
        }
        return keyPair;
    }

    @Override
    public KeyEntity sign(KeyEntity entity) {
        return super.sign(entity);
    }

    @Override
    public boolean verifySign(KeyEntity entity) {
        return super.verifySign(entity);
    }


    @Override
    public KeyEntity issuingRootCertificate(KeyEntity entity) {
        return super.commonIssuingCertificate(null, entity, false);
    }

    @Override
    public KeyEntity issuingSubCertificate(KeyEntity rootEntity, KeyEntity subEntity) {
        return super.commonIssuingCertificate(rootEntity, subEntity, false);
    }

    @Override
    public KeyEntity issuingUserCertificate(KeyEntity rootEntity, KeyEntity userEntity) {
        return super.commonIssuingCertificate(rootEntity, userEntity, true);
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
        AlgorithmIdentifier identifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, new ASN1ObjectIdentifier("1.2.156.10197.1.301"));
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
