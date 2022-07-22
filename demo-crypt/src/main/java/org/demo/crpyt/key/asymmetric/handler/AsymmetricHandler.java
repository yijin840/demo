package org.demo.crpyt.key.asymmetric.handler;


import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.handler.KeyHandler;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
public interface AsymmetricHandler extends KeyHandler {

    /**
     * 签名
     *
     * @param entity 需要签名的数据
     * @return 签名完毕的数据
     */
    KeyEntity sign(KeyEntity entity);

    /**
     * 验证签名
     *
     * @param entity 验证签名的数据
     * @return 验证结果
     */
    boolean verifySign(KeyEntity entity);


}
