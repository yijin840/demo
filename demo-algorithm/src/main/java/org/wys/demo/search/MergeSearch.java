package org.wys.demo.search;

/**
 * @author wys
 * @date 2021/12/29
 */
public class MergeSearch {

    /**
     * 归并查找，类似于二分思想
     *
     * @param arr 数组
     * @return 最大值
     */
    public static int getMaxValue(int[] arr) {
        if (arr.length == 0) {
            throw new RuntimeException("Array size is zero");
        }
        return getMaxValue(arr, 0, arr.length - 1);
    }

    /**
     * 数组
     *
     * @param arr   数组
     * @param left  起点
     * @param right 终点
     * @return 最大值
     */
    private static int getMaxValue(int[] arr, int left, int right) {
        if (left >= right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int leftMaxValue = getMaxValue(arr, left, mid);
        int rightMaxValue = getMaxValue(arr, mid + 1, right);
        return Math.max(leftMaxValue, rightMaxValue);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,5,6,7,8,3,3,1,2};
        System.out.println(getMaxValue(arr));
    }

}
