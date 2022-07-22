package org.demo.crpyt.key.symmetric.bc;

import lombok.extern.slf4j.Slf4j;
import org.demo.crpyt.constant.AlgorithmConstant;
import org.demo.crpyt.constant.CipherConstant;
import org.demo.crpyt.entity.KeyEntity;
import org.demo.crpyt.key.symmetric.handler.AbstractSymmetricKey;

/**
 * @author wys
 * @date 2022/07/12
 * @desc
 */
@Slf4j
public class DesBcStrategy extends AbstractSymmetricKey {

    public DesBcStrategy() {
        super(CipherConstant.DES);
    }

    @Override
    public KeyEntity encrypt(String data) {
        return super.encrypt(data, getAlgorithm());
    }

    @Override
    public String decrypt(KeyEntity symmetric) {
        return super.decrypt(symmetric);
    }

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.DES;
    }
}
