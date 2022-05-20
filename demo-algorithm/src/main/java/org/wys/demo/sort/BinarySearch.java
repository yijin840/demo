package org.wys.demo.sort;

/**
 * @author wys
 * @date 2022/5/18
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1, 3, 5, 6};
        int x = 4;
        System.out.println(binarySearch.searchInsert(nums, x));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if(nums[left] > target) {
            return 0;
        }
        if(nums[right] < target) {
            return nums.length;
        }
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left++;
            } else if(nums[mid] > target) {
                right--;
            }
        }
        return left;
    }

}
