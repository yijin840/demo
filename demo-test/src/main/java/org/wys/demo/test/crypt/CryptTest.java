package org.wys.demo.test.crypt;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.Hex;
import org.demo.crpyt.constant.SignatureConstant;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.asymmetric.bc.RsaBcStrategy;
import org.demo.crpyt.key.asymmetric.handler.AsymmetricKeyHandler;
import org.junit.jupiter.api.Test;
import org.wys.demo.common.exception.CryptException;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.cert.CertificateEncodingException;

/**
 * @author wys
 * @date 2022/07/22
 * @desc
 */
@Slf4j
public class CryptTest {

    @Test
    public void test() {
        //第一个Key
        AsymmetricKeyHandler rsa = new RsaBcStrategy();
        String data = "你好啊";
        KeyEntity entity = rsa.encrypt(data);
        String decrypt = rsa.decrypt(entity);
        log.info("one : encrypt ====> {} \n  decrypt ====> {}", Hex.toHexString(entity.getData()), decrypt);
        //签名
        entity.setSignAlgorithm(SignatureConstant.MD5_WITH_RSA);
        KeyEntity sign = rsa.sign(entity);
        log.info("sign after ===> {}", sign.getData());
        boolean signedInspection = rsa.verifySign(entity);
        log.info("sign result ===> {}", signedInspection);
        entity.setCertificate(RsaBcStrategy.mock());
        //根证书
        KeyEntity ec = rsa.issuingRootCertificate(entity);
        log.info("root certificate ===> {}\n\n", ec.getCertificate());
        //证书生成
        try (FileOutputStream fos = new FileOutputStream("root.cer");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(ec.getCertificate().getCertificate().getEncoded());
            bos.flush();
        } catch (IOException | CertificateEncodingException e) {
            throw new CryptException(e);
        }

        //第二个Key
        String subData = "中间证书";
        KeyEntity subEntity = rsa.encrypt(subData);
        String subDecrypt = rsa.decrypt(subEntity);
        log.info("two : encrypt ====> {} \n  decrypt ====> {}", Hex.toHexString(subEntity.getData()), subDecrypt);
        //签名
        subEntity.setSignAlgorithm(SignatureConstant.MD5_WITH_RSA);
        KeyEntity subSign = rsa.sign(subEntity);
        log.info("sign after ===> {}", subSign.getData());
        boolean subSignedInspection = rsa.verifySign(subSign);
        log.info("sign result ===> {}", subSignedInspection);
        //中间证书
        subEntity.setCertificate(RsaBcStrategy.mock());
        KeyEntity subEc = rsa.issuingSubCertificate(entity, subEntity);
        //证书生成
        try (FileOutputStream fos = new FileOutputStream("sub.cer");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(subEc.getCertificate().getCertificate().getEncoded());
            bos.flush();
        } catch (IOException | CertificateEncodingException e) {
            throw new CryptException(e);
        }


        //第二个Key
        String ktwData = "我很好";
        KeyEntity kwtEntity = rsa.encrypt(ktwData);
        String kwtDecrypt = rsa.decrypt(kwtEntity);
        log.info("two : encrypt ====> {} \n  decrypt ====> {}", Hex.toHexString(kwtEntity.getData()), kwtDecrypt);
        //签名
        kwtEntity.setSignAlgorithm(SignatureConstant.MD5_WITH_RSA);
        KeyEntity kwtSign = rsa.sign(kwtEntity);
        log.info("sign after ===> {}", kwtSign.getData());
        boolean ktwSignedInspection = rsa.verifySign(kwtSign);
        log.info("sign result ===> {}", ktwSignedInspection);
        //用户证书
        kwtEntity.setCertificate(RsaBcStrategy.mock());
        KeyEntity userEntity = rsa.issuingUserCertificate(subEntity, kwtEntity);
        //证书生成
        try (FileOutputStream fos = new FileOutputStream("user.cer");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(userEntity.getCertificate().getCertificate().getEncoded());
            bos.flush();
        } catch (IOException | CertificateEncodingException e) {
            throw new CryptException(e);
        }
    }
}
