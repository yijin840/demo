package org.wys.demo.test;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2022/3/14
 */
public class StringTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countCollisions("RLRSLL"));
    }

    static class Solution {
        public int countCollisions(String directions) {
            char[] dire = directions.toCharArray();
            int res = 0;
            int l = 0;
            for (int i = 0; i < dire.length; i++) {
                if (dire[i] == 'L' && i != 0) {
                    if (dire[i - 1] == 'R') {
                        res += 2;
                        dire[i - 1] = 'S';
                        dire[i] = 'S';
                        i += 1;
                    } else if (dire[i - 1] == 'S') {
                        res += 1;
                        dire[i] = 'S';

                    }
                }
                if (dire[i] == 'R' && i != dire.length - 1) {
                    if (dire[i + 1] == 'L') {
                        res += 2 + l;
                        dire[i] = 'S';
                        dire[i + 1] = 'S';
                        l = 0;
                        i += 1;
                    } else if (dire[i + 1] == 'S') {
                        res += 1 + l;
                        dire[i] = 'S';
                        l = 0;
                    } else if (dire[i] == 'R') {
                        l++;
                    }
                }
            }
            return res;
        }

        private void print(char[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }
            System.out.println();
        }
    }
}
