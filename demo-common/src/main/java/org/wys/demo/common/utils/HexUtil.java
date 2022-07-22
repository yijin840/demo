package org.wys.demo.common.utils;

/**
 * @author wys
 * @date 2022/07/15
 * @desc
 */
public class HexUtil {

    private static final char[] CHS = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    /**
     * 把十进制转换成十六进制
     * @param bytes
     * @return
     */
    public static String toHex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b : bytes) {
            stringBuilder.append(toHex(b));
        }
        return stringBuilder.toString();
}

    /**
     * 把单个十进制转换成十六进制
     * 因为byte最大256所以，不需要迭代整除
     * byte范围 -128 ~ 127 , 四字节
     * @param b 字节b，十进制
     * @return 十六进制字符串
     */
    private static String toHex(byte b) {
        int n = b;
        if(b < 0) {
            n = 256 + b;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return "" + CHS[d1] + CHS[d2];
    }

}
