package org.wys.demo.string;

import java.util.Arrays;

/**
 * @author wys
 * @date 2022/3/29
 */
public class KmpStrMatcher {

    private int[] nextArr;

    public KmpStrMatcher() {
    }

    /**
     * 解析字符串匹配索引
     *
     * @param originStr 原字符串
     * @param targetStr 匹配的字符串
     * @return 匹配索引位置
     */
    public int match(String originStr, String targetStr) {
        getNext(targetStr);
        return kmp(originStr, targetStr);
    }


    /**
     * kmp匹配字符串
     *
     * @param originStr 原字符串
     * @param targetStr 匹配的字符串
     * @return 匹配到的索引位置
     */
    private int kmp(String originStr, String targetStr) {
        int i = 0;
        int j = 0;
        while (i < originStr.length() && j < targetStr.length()) {
            if (j == -1 || originStr.charAt(i) == targetStr.charAt(j)) {
                i++;
                j++;
            } else {
                j = nextArr[j];
            }
        }
        if (j == targetStr.length()) {
            return i - j;
        } else {
            return -1;
        }
    }


    /**
     * 前缀表构建
     *
     * @param targetStr 匹配的目标字符串
     */
    private void getNext(String targetStr) {
        nextArr = new int[targetStr.length() + 1];
        int i = 0, j = -1;
        nextArr[0] = -1;
        while (i < targetStr.length()) {
            if (j == -1 || targetStr.charAt(i) == targetStr.charAt(j)) {
                ++i;
                ++j;
                nextArr[i] = j;
            } else {
                j = nextArr[j];
            }
        }
    }

    public static void main(String[] args) {
        KmpStrMatcher matcher = new KmpStrMatcher();
        String s1 = "abcaabcdefgabc";
        String s2 = "abc";
        String s3 = "efg";
        int index1 = matcher.match(s1, s2);
//        for (int i : matcher.nextArr) {
//            System.out.println(i);
//        }
        System.out.println(index1);
    }
}
