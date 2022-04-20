package org.wys.demo.sort;

import org.springframework.util.StopWatch;

import java.util.Random;

/**
 * @author wys
 * @date 2022/4/20
 */
public class MonkeySort {

    public static void main(String[] args) {
        MonkeySort sort = new MonkeySort();
        int[] arr = new int[]{5, 3, 1, 4, 2, 9 ,6, 8, 7,10};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sort.sort(arr);
        stopWatch.stop();
        System.out.println("排序消耗时间: " + (stopWatch.getTotalTimeMillis()/1000) + "s");
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr) {
        int l = 0;
        while (true) {
            Random random = new Random();
            for (int i = 0; i < arr.length; i++) {
                int x = random.nextInt(arr.length - 1);
                int t = arr[i];
                arr[i] = arr[x];
                arr[x] = t;
            }
            if(checkOrder(arr)) {
                System.out.print("第" + l + "次排序...  ");
                break;
            } else {
                System.out.print("第" + l + "次排序...  ");
                for(int i=0;i<arr.length;i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            l++;
        }
    }

    private boolean checkOrder(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }
        return true;
    }


}
