package org.demo.crpyt.key.digest;

import org.demo.crpyt.constant.AlgorithmConstant;

/**
 * @author wys
 * @date 2022/07/15
 * @desc
 */
public class SHA256 extends AbstractMessageDigest {
    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.SHA_256;
    }
}
