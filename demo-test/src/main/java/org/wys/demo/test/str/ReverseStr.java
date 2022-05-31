package org.wys.demo.test.str;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

/**
 * @author wys
 * @date 2022/4/18
 */
public class ReverseStr {
    public static void main(String[] args) {
        long x1 = System.currentTimeMillis();
//        System.out.println(x1);
        String base = "Welcome yggilf 123fliggy123 fliggy to ABfliggySHDfliggyAD!";
        String fliggy = "fliggy";
        for (int i = 0; i < 10000; i++) {
            base = getString(base, fliggy);
//            String fliggy = reverse(base, "fliggy");
//            System.out.println(fliggy);
//            System.out.println("!DAfliggyDHSfliggyBA OT YGGILF 321fliggy321 FLIGGY EMOCLEW");
//            System.out.println("Welcome yggilf 123fliggy123 FLIGGY to ABfliggySHDfliggyAD!");
//            System.out.println(fliggy.equals("!DAfliggyDHSfliggyBA OT YGGILF 321fliggy321 FLIGGY EMOCLEW"));
        }
        System.out.println(System.currentTimeMillis() - x1);


//
    }

    @NotNull
    private static String getString(String base, String fliggy) {
        base = base.replaceAll(fliggy, "###");
        char[] chars = base.toCharArray();
        char[] changeChar = changeChar(chars);
        String x = new String(changeChar);
        String reverse = StringUtils.reverse(x);
        reverse = reverse.replaceAll("###", fliggy);
//        System.out.println(reverse);
        return base;
    }

    private static char[] changeChar(char[] chars) {
        char[] result = chars;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (97 <= aChar &&  aChar <= 122) {
                result[i] = (char) (aChar - 32);
            }
        }
        return result;
    }

    private static String reverse(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        int oriPos = 0;
        int lastOriPos = 0;
        StringBuilder rs2 = new StringBuilder();
        for (int k = s2.length() - 1; k >= 0; k--) {
            rs2.append(s2.charAt(k));
        }
        StringBuilder temp;
        while (i < s1.length()) {
            //两个同时走，如果能走到头，就是字串，否则就要回溯
            if (s1.charAt(i) == s2.charAt(j)) {
                //如果走到头了，说明这个就是想要的字串,不需要逆序
                if (j == s2.length() - 1) {
                    temp = new StringBuilder();
                    for (int k = lastOriPos; k < oriPos; k++) {
                        temp.append(s1.charAt(k));
                    }
                    res.append(temp.toString().toUpperCase());
                    res.append(rs2);
                    j = 0;
                    oriPos = i + 1;
                    lastOriPos = oriPos;
                } else {
                    j++;
                }
            } else {
                oriPos = i + 1;
                j = 0;
            }
            i++;
        }
        //说明没走完还剩一点就要反转
        if (j != s2.length() - 1) {
            temp = new StringBuilder();
            for(int k=lastOriPos;k<s1.length();k++) {
                temp.append(s1.charAt(k));
            }
            res.append(temp);
        }
        return res.reverse().toString();
    }
}
