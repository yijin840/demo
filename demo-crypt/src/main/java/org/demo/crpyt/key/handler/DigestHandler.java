package org.demo.crpyt.key.handler;

/**
 * @author wys
 * @date 2022/07/14
 * @desc
 */
public interface DigestHandler {

    /**
     * 对数据进行摘要加密
     * @param data 数据
     * @return 加密后的数据
     */
    byte[] encrypt(String data);

}
