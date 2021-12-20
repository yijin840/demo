package org.wys.demo.sort;

/**
 * @author wys
 * @date 2021/11/18 9:36
 * @since 1.0.0
 */
public class SortUtil {

    /**
     * 快排
     *
     * @param left  左区间
     * @param right 右区间
     * @param arr   待排序数组
     */
    public static void quickSort(int left, int right, int[] arr) {
        //如果左边大于右边，那么直接结束
        if (left > right) {
            return;
        }
        //找基准
        int temp = arr[left];
        //区间
        int low = left;
        int high = right;
        //交换值
        int t;
        while (low != high) {
            while (arr[high] >= temp && low < high) {
                high--;
            }
            while (arr[low] <= temp && low < high) {
                low++;
            }
            t = arr[low];
            arr[low] = arr[high];
            arr[high] = t;
        }
        //一轮排序结束，基准归位
        arr[left] = arr[low];
        arr[low] = temp;
        quickSort(left, high-1, arr);
        quickSort(low+1, right, arr);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,4,6};
        quickSort(0,arr.length-1,arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
