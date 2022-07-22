package org.demo.crpyt.key.handler;

import org.demo.crpyt.entity.KeyEntity;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
public interface KeyHandler {

    /**
     * 加密数据
     * @param data 需要加密的数据，目前是只有String类型
     * @return 返回加密后的实体类
     */
    KeyEntity encrypt(String data);

    /**
     * 解密数据
     * @param entity 封装的加密实体类
     * @return 解密后的数据
     */
    String decrypt(KeyEntity entity);

}
