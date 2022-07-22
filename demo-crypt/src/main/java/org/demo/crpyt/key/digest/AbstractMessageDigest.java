package org.demo.crpyt.key.digest;

import org.demo.crpyt.key.handler.DigestHandler;
import org.wys.demo.common.exception.CryptException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wys
 * @date 2022/07/15
 * @desc
 */
public abstract class AbstractMessageDigest implements DigestHandler {

    @Override
    public byte[] encrypt(String data) {
        byte[] res;
        try {
            MessageDigest digest = MessageDigest.getInstance(getAlgorithm());
            res = digest.digest(data.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new CryptException(e);
        }
        return res;
    }

    /**
     * 获取当前算法
     * @return 返回当前算法
     */
    public abstract String getAlgorithm();
}
