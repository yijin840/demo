package org.demo.crpyt.key.symmetric.bc;

import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.CipherConstant;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.symmetric.handler.AbstractSymmetricKey;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
public class BaseSymmetricKeyBcStrategy extends AbstractSymmetricKey {

    public BaseSymmetricKeyBcStrategy() {
        super(CipherConstant.NONE);
    }

    @Override
    public KeyEntity encrypt(String data) {
        return KeyEntity.KeyEntityBuilder.builder().build();
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.SM4;
    }
}
