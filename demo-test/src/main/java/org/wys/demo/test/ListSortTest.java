package org.wys.demo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wys
 * @date 2022/5/24
 */
public class ListSortTest {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
    static class Solution {
        public int trap(int[] height) {
            int res = 0;
            for(int i=1;i<height.length-1;i++) {
                if(height[i-1] > height[i] && height[i+1] > height[i]) {
                    res += getSum(height, i);
                }
            }
            return res;
        }

        private int getSum(int[] height, int x) {
            int left = x;
            int right = x;
            int leftNum = height[x];
            int rightNum = height[x];
            int sum = 0;
            for(int i=x-1;i>=0;i--) {
                if(height[i] >= leftNum) {
                    leftNum = height[i];
                    left = i;
                } else {
                    break;
                }
            }
            for(int i=x+1;i<height.length;i++) {
                if(height[i] >= right) {
                    rightNum = height[i];
                    right = i;
                } else {
                    break;
                }
            }
            List<Integer> list = new ArrayList<>();
            for(int i=left;i<=right;i++) {
                System.out.println(height[i]);
                list.add(height[i]);
            }
            Collections.sort(list);
            int temp = Math.min(leftNum, rightNum);
            for(int i=0;i<list.size();i++) {
                sum += (temp - height[i]);
                System.out.println(temp + " : " + height[i]);
            }
            System.out.println();
            return sum;
        }

    }
}
