package org.demo.crpyt.key.symmetric.handler;

import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.handler.AbstractKey;
import org.wys.demo.common.exception.CryptException;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public abstract class AbstractSymmetricKey extends AbstractKey implements SymmetricHandler {

    protected final int DES_SIZE = 64;

    protected final int DES_EDE_SIZE = 168;
    protected final int AES_SIZE = 128;


    public AbstractSymmetricKey() {

    }

    public AbstractSymmetricKey(String constant) {
        super(constant);
    }

    /**
     * 指定算法加密，暂只支持 AES， DES， 3DES
     * @param data 数据
     * @param algorithm 算法
     * @return 加密结果
     */
    public KeyEntity encrypt(String data, String algorithm) {
//        if (!StringUtils.equalsStr(algorithm, AlgorithmConstant.AES)
//                && !StringUtils.equalsStr(algorithm, AlgorithmConstant.DES)
//                && !StringUtils.equalsStr(algorithm, AlgorithmConstant.DES_SEDE)) {
//            throw new CryptException("the current algorithm is not currently supported");
//        }
        KeyEntity symmetric = new KeyEntity();
        try {
            //1、生成密钥
            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm, source());
            keyGenerator.init(AES_SIZE);
            SecretKey baseKey = keyGenerator.generateKey();

            //转换密钥
            KeySpec aesKeySpec = new SecretKeySpec(baseKey.getEncoded(), algorithm);
            Provider provider = keyGenerator.getProvider();
            SecretKeyFactory factory = SecretKeyFactory.getInstance(algorithm, provider);
            SecretKey secretKey = factory.generateSecret(aesKeySpec);

            //初始化 & 加密
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptData = cipher.doFinal(data.getBytes());

            //组装数据
            symmetric.setData(encryptData);
            symmetric.setAlgorithm(algorithm);
            symmetric.setKey(secretKey);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e) {
            throw new CryptException(e);
        }

        return symmetric;
    }

    public String decrypt(KeyEntity keyEntity) {
        String res;
        try {
            cipher.init(Cipher.DECRYPT_MODE, keyEntity.getKey());
            byte[] decryptData = cipher.doFinal(keyEntity.getData());
            res = new String(decryptData, StandardCharsets.UTF_8);
        } catch (InvalidKeyException | BadPaddingException | IllegalBlockSizeException e) {
            throw new CryptException(e);
        }
        return res;
    }

    protected String source() {
        return "BC";
    }

}
