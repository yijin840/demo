package org.wys.demo.test.str;

/**
 * @author wys
 * @date 2022/4/13
 */
public class SwapTest {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        System.out.println("swap before: " + arr[0] + ":" + arr[1]);
        swap(arr, 0, 1);
        System.out.println("swap after: " + arr[0] + ":" + arr[1]);
    }

    public static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}
