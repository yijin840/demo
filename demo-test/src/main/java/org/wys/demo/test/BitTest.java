package org.wys.demo.test;

/**
 * @author wys
 * @date 2022/3/29
 */
public class BitTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxRotateFunction(new int[]{1,2,3,4});
    }
    static class Solution {
        public int maxRotateFunction(int[] nums) {
            int res = getSum(nums);
            int num = 0;
            for(int i=0;i<nums.length;i++) {
                num += nums[i];
            }
            int i = 0;
            while(i<nums.length - 1) {
                i++;
                int sum = (res - num)- ((nums.length-1) * nums[nums.length - i - 1]);
                res = Math.max(res, sum);
            }
            return res;
        }
        //1 2 3 4
        //0 * 1 + 1 * 2 + 2 * 3 + 3 * 4   2 +6 + 12 = 20
        // 0 * 4 + 1 * 1 + 2 * 2 + 3 * 3 20 - 10 - 6 = 14
        // 0  * 3 + 1 * 4 + 2 * 1 + 3 * 2
        private int getSum(int[] arr) {
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum += i * arr[i];
            }
            return sum;
        }
    }
}
