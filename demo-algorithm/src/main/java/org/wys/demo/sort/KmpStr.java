package org.wys.demo.sort;

/**
 * @author wys
 * @date 2022/4/28
 */
public class KmpStr {

    public static void main(String[] args){
        String str = "aabcsdas";
        String pattern = "abcsd";
        System.out.println(kmp(str, pattern));
    }

    public static int kmp(String str, String pattern) {
        int[] next = getNext(pattern);
        int i = 0, j = 0;
        while (i < str.length() && j < pattern.length()) {
            if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == pattern.length() ? i - j : -1;
    }
    public static int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int i = 0, j = -1;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
