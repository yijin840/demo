package org.wys.demo.search;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ClassName PriorityQueueUtil
 * Package org.wys.demo.search
 * Description
 *
 * @author wys
 * @date 2022/6/28 12:05
 */
public class PriorityQueueUtil {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>((x,y) -> y-x);
        queue.add(1);
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }

}
