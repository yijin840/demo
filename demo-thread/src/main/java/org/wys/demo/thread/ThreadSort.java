package org.wys.demo.thread;

/**
 * @author wys
 * @date 2022/4/8
 */
@SuppressWarnings("all")
public class ThreadSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 1, 2, 4};
        for (int i = 0; i < arr.length; i++) {
            final int n = i;
            new Thread(() -> {
                try {
                    Thread.sleep(arr[n] * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(arr[n]);
            }, i + "线程").start();
        }
    }
}
