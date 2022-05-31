package org.wys.demo.test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author wys
 * @date 2022/3/29
 */
public class BitTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = nums2.length - 1; i >= 0; i--) {
                int x = nums2[i];
                while (!stack.isEmpty() && stack.getFirst() < x) {
                    stack.pop();
                }
                map.put(x, !stack.isEmpty() ? stack.getFirst() : -1);
                stack.push(x);
            }
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
}
