package org.demo.crpyt.constant;

import org.wys.demo.common.annotation.DictItem;
import org.wys.demo.common.annotation.Dictionary;

/**
 * @author wys
 * @date 2022/07/12
 * @desc 算法/模式/补码方式
 */
@Dictionary("密码头")
public interface CipherConstant {

    @DictItem("DES密码头")
    String DES = "DES/ECB/PKCS5Padding";

    @DictItem("3DES密码头")
    String DES3 = "DESede/ECB/PKCS5Padding";

    @DictItem("AES密码头")
    String AES = "AES/ECB/PKCS5Padding";

    @DictItem("RC4密码头")
    String RC4 = "NONE";

    @DictItem("SM1密码头")
    String SM1 = "NONE";

    @DictItem("SM4密码头")
    String SM4 = "SM4/ECB/PKCS5Padding";

    @DictItem("无")
    String NONE = "NONE";

    @DictItem("SM2密码头")
    String SM2 = "SM2";
    @DictItem("RSA密码头")
    String RSA = "RSA/None/OAEPWithSHA-256AndMGF1Padding";


}
