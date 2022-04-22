package org.wys.demo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2022/4/22
 */
public class ParallelTime {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

    }

    public int calNumber() {
        int sum = 0;
        for(int i=0;i<1000000;i++) {
            sum += i;
        }
        return sum;
    }

}
