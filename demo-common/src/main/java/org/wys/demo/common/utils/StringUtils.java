package org.wys.demo.common.utils;

/**
 * @author wys
 * @date 2022/07/12
 * @desc 字符串工具类
 */
public class StringUtils {

    /**
     * 字符串比较器
     *
     * @param origin 原字符串
     * @param target 目标字符串
     * @return 比较结果
     */
    public static boolean equalsStr(String origin, String target) {
        if (origin == null && target == null) {
            return true;
        }
        if (origin == null) {
            return false;
        }
        if (target == null) {
            return false;
        }
        if (origin.length() != target.length()) {
            return false;
        }
        char[] originArray = origin.toCharArray();
        char[] targetArray = target.toCharArray();
        for (int i = 0; i < origin.length(); i++) {
            if (originArray[i] != targetArray[i]) {
                return false;
            }
        }
        return true;
    }

}
