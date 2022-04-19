package org.wys.demo.test.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2022/4/18
 */
public class KmpReverseStr {
    public static void main(String[] args) {
        String s1 = "Welcome yggilf 123fliggy123 FLIGGY to ABfliggySHDfliggyAD!";
        String s2 = "fliggy";
        int index = s1.indexOf(s2);
        while (index != -1) {
            index = s1.indexOf(s2);
            System.out.println(index);
        }
    }


    private static int[] next(String s2) {
        int[] next = new int[s2.length() + 1];
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < s2.length()) {
            if (j == -1 || s2.charAt(i) == s2.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    private static List<Integer> kmp(String s1, String s2) {
        int[] next = next(s2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < s1.length()) {
            while (j < s2.length()) {
                if (i >= s1.length()) {
                    break;
                }
                if (j == -1 || s1.charAt(i) == s2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
            }
            list.add(i - j);
            j = 0;
        }
        return list;
    }
}
