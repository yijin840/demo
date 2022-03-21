package org.wys.demo.test;

import java.util.Arrays;

/**
 * @author wys
 * @date 2022/3/17
 */
public class LtDemo {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    static class Solution {

        public String longestWord(String[] words) {
            Arrays.sort(words);

            return words[words.length-1];
        }
    }
}
