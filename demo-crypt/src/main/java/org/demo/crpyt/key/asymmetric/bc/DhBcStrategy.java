package org.demo.crpyt.key.asymmetric.bc;

import lombok.extern.slf4j.Slf4j;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.asymmetric.handler.AsymmetricKeyHandler;
import org.wys.demo.common.exception.CryptException;

import javax.crypto.KeyAgreement;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author wys
 * @date 2022/07/14
 * @desc
 */
@Slf4j
public class DhBcStrategy extends AsymmetricKeyHandler {

    private static final int MIDDLE = 512;

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.DH;
    }

    @Override
    public KeyEntity encrypt(String data) {
        throw new CryptException("DH can not encrypt");
    }

    @Override
    public String decrypt(KeyEntity entity) {
        throw new CryptException("DH can not decrypt");
    }

    /**
     * 根据对方的公钥和自己的私钥生成私钥
     *
     * @param receiveKey     接收到公钥
     * @param selfPrivateKey 自己的私钥
     * @return 返回生成的私钥
     */
    public byte[] generateSecretKey(PublicKey receiveKey, PrivateKey selfPrivateKey) {
        byte[] secret;
        try {
            //通过X509规范解析公钥
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receiveKey.getEncoded());
            //生成DH公钥
            KeyFactory keyFactory = KeyFactory.getInstance(getAlgorithm());
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            //根据私钥和对方公钥生成新的私钥
            KeyAgreement keyAgreement = KeyAgreement.getInstance(getAlgorithm());
            keyAgreement.init(selfPrivateKey);
            keyAgreement.doPhase(publicKey, true);
            secret = keyAgreement.generateSecret();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidKeyException e) {
            throw new CryptException(e);
        }
        return secret;
    }


    @Override
    public KeyPair generateKeyPair() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(getAlgorithm());
            keyPairGenerator.initialize(MIDDLE);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e);
        }
        return keyPair;
    }

    @Override
    public KeyEntity sign(KeyEntity entity) {
        return null;
    }

    @Override
    public boolean verifySign(KeyEntity entity) {
        return false;
    }

}
