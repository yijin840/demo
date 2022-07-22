package org.demo.crpyt.constant;

import org.wys.demo.common.annotation.DictItem;
import org.wys.demo.common.annotation.Dictionary;

/**
 * @author wys
 * @date 2022/07/18
 * @desc
 */
@Dictionary("签名算法信息")
public interface SignatureConstant {

    @DictItem("RSA采用MD5形式")
    String MD5_WITH_RSA = "MD5withRSA";

    @DictItem("RSA采用MD2形式")
    String MD2_WITH_RSA = "MD2withRSA";

    @DictItem("RSA采用SHA1形式")
    String SHA1_WITH_RSA = "SHA1withRSA";

    @DictItem("RSA采用SHA224形式")
    String SHA224_WITH_RSA = "SHA224withRSA";

    @DictItem("RSA采用SHA256形式")
    String SHA256_WITH_RSA = "SHA256withRSA";

    @DictItem("RSA采用SHA384形式")
    String SHA384_WITH_RSA = "SHA384withRSA";

    @DictItem("RSA采用SHA512形式")
    String SHA512_WITH_RSA = "SHA512withRSA";

    @DictItem("RSA采用RIPEMD128形式")
    String RIPEMD128_WITH_RSA = "RIPEMD128withRSA";

    @DictItem("RSA采用RIPEMD160形式")
    String RIPEMD160_WITH_RSA = "RIPEMD160withRSA";

    @DictItem("SM2使用SHA256")
    String SHA256_WITH_SM2 = "SHA256withSM2";

    @DictItem("SM2使用SM3")
    String SM3_WITH_SM2 = "SM3withSM2";


}
