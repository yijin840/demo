package org.wys.demo.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wys
 * @date 2022/5/11
 */
public class BannedTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "Bob. hIt, baLl";
        String[] banned = new String[]{"bob", "hit"};
        System.out.println(solution.mostCommonWord(s, banned));

    }

    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph = paragraph + ",";
            paragraph = paragraph.toLowerCase();
            String temp;
            int maxNum = 0;
            String res = "";
            int lastIndex = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < paragraph.length(); i++) {
                if (paragraph.charAt(i) < 'a' || paragraph.charAt(i) > 'z') {
                    temp = paragraph.substring(lastIndex, i);
                    boolean isExist = false;
                    for (String s : banned) {
                        if (s.equals(temp)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (!isExist && temp.length() > 0) {
                        int tempNum = map.getOrDefault(temp, 0) + 1;
                        if (tempNum > maxNum) {
                            maxNum = tempNum;
                            res = temp;
                        }
                        map.put(temp, tempNum);
                    }
                    lastIndex = i + 1;
                }
            }
            if (lastIndex == 0) {
                return paragraph;
            }
            return res;
        }
    }
}
