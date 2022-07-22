package org.demo.crpyt.constant;

import org.wys.demo.common.annotation.DictItem;
import org.wys.demo.common.annotation.Dictionary;

/**
 * @author wys
 * @date 2022/07/12
 * @desc 算法头
 */
@Dictionary("算法头")
public interface AlgorithmConstant {

    @DictItem("DES算法")
    String DES = "DES";

    @DictItem("3DES算法")
    String DES_SEDE = "DESede";

    @DictItem("AES算法")
    String AES = "AES";

    @DictItem("RC4算法")
    String RC4 = "RC4";

    @DictItem("SM1算法")
    String SM1 = "SM1";

    @DictItem("SM4算法")
    String SM4 = "SM4";

    @DictItem("SM2算法")
    String SM2 = "SM2";

    @DictItem("ECB算法")
    String ECB = "ECB";

    @DictItem("CBC算法")
    String CBC = "CBC";

    @DictItem("GCM算法")
    String GCM = "GCM";

    @DictItem("RSA加密")
    String RSA = "RSA";

    @DictItem("椭圆曲线算法")
    String EC = "EC";

    @DictItem("DH算法")
    String DH = "DH";

    @DictItem("MD5算法")
    String MD5 = "MD5";

    @DictItem("SHA-256算法")
    String SHA_256 = "SHA-256";

}
