package org.demo.crpyt.key.symmetric.bc;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
public class Sm4BcStrategy {

    static {

    }
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance("SM2/ECB/PKCS5Padding");
    }

}

