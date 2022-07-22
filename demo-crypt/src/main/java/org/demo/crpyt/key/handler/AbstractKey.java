package org.demo.crpyt.key.handler;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.demo.crpyt.constant.CipherConstant;
import org.wys.demo.common.exception.CryptException;
import org.wys.demo.common.utils.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @author wys
 * @date 2022/07/13
 * @desc
 */
public abstract class AbstractKey {

    protected Cipher cipher;

    protected static final BouncyCastleProvider PROVIDER;
    protected static final String SUN_EC = "SunEC";
    static {
        PROVIDER = new BouncyCastleProvider();
        Security.addProvider(PROVIDER);
        Security.removeProvider(SUN_EC);
    }

    public AbstractKey() {

    }
    /**
     * 初始化必要的参数，并且注册bc库
     * 如果密码头为空， 就不需要注册
     * @param constant 算法头
     */
    public AbstractKey(String constant) {
        try {
            if(!StringUtils.equalsStr(constant, CipherConstant.NONE)) {
                cipher = Cipher.getInstance(constant);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new CryptException(e);
        }
    }

    /**
     * 获取当前算法
     * @return 返回当前算法名称
     */
    public abstract String getAlgorithm();

}
