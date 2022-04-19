package org.wys.demo.test.str;

import java.util.Locale;

/**
 * @author wys
 * @date 2022/4/18
 */
public class ReverseStr {
    public static void main(String[] args) {
        String fliggy = reverse("fliggyWelcome yggilf 123fliggy123 FLIGGY to ABfliggySHDfliggyAD!fliggy", "fliggy");
        System.out.println(fliggy);
        System.out.println("!DAfliggyDHSfliggyBA OT YGGILF 321fliggy321 FLIGGY EMOCLEW");
        System.out.println(fliggy.equals("!DAfliggyDHSfliggyBA OT YGGILF 321fliggy321 FLIGGY EMOCLEW"));
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
