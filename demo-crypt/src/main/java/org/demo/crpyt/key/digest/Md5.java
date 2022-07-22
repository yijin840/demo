package org.demo.crpyt.key.digest;

import org.demo.crpyt.constant.AlgorithmConstant;

/**
 * @author wys
 * @date 2022/07/14
 * @desc
 */
public class Md5 extends AbstractMessageDigest {

    @Override
    public String getAlgorithm() {
        return AlgorithmConstant.MD5;
    }
}
