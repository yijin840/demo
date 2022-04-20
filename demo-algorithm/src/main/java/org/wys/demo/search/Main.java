package org.wys.demo.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.maximumCandies(new int[]{4, 7, 5}, 4));
    }

    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        for (int i = candies[candies.length - 1]; i >= 1; i--) {
            int count = 0;
            for (int j = candies.length - 1; j >= 0; j--) {
                count += candies[j] / i;
                if (count >= k) {
                    System.out.println(count+":"+k);
                    return i;
                }
            }
        }
        String s;
        return 0;
    }

}
