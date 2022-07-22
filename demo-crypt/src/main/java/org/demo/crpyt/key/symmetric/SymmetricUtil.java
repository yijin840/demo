package org.demo.crpyt.key.symmetric;

/**
 * @author wys
 * @date 2022/07/08
 * @desc
 */
public class SymmetricUtil {

    /**
     * 交换数组元素对象
     * @param arr 数组对象
     * @param left 左
     * @param right 右
     */
    public static void swap(int[] arr, int left, int right) {
        int t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

    /**
     * 交换数组元素对象
     * @param arr 数组对象
     * @param left 左
     * @param right 右
     */
    public static void swap(char[] arr, int left, int right) {
        char t = arr[left];
        arr[left] = arr[right];
        arr[right] = t;
    }

}
