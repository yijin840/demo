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
public class AesBcStrategy extends AbstractSymmetricKey {

    public AesBcStrategy() {
        super(CipherConstant.AES);
    }

    @Override
    public KeyEntity encrypt(String data) {
        return super.encrypt(data, getAlgorithm());
    }

    @Override
    public String decrypt(KeyEntity keyEntity) {
        return super.decrypt(keyEntity);
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.AES;
    }
}
