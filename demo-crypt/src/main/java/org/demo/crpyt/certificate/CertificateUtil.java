package org.demo.crpyt.certificate;

import java.util.UUID;

/**
 * @author wys
 * @date 2022/07/18
 * @desc
 */
public class CertificateUtil {


    public static String getName() {
        String CN = UUID.randomUUID().toString().substring(0,4);
        String OU = UUID.randomUUID().toString().substring(0,4);
        String O = UUID.randomUUID().toString().substring(0,4);
        String L = UUID.randomUUID().toString().substring(0,4);
        String St = UUID.randomUUID().toString().substring(0,4);
        String C = UUID.randomUUID().toString().substring(0,4);
        String name = "CN=" + CN + ",OU=" + OU + ",O=" + O + ",L=" + L + ",St=" + St + ",C=" + C;
        return name;
    }

}
