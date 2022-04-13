package org.wys.demo.thread;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wys
 * @date 2022/4/8
 */
@SuppressWarnings("all")
public class ThreadSort {

    public static void main(String[] args) {
        List<Long> l1 = Lists.newArrayList(1L,2L,3L,4L);
        List<Long> l2 = Lists.newArrayList(1L,2L,3L,4L);
        List<Long> l3 = Lists.newArrayList(1L,2L,3L,4L);
        Set<Long> s1 = new HashSet<>();
        s1.addAll(l1);
        l2.addAll(Lists.newArrayList(s1));
        l2.addAll(l1);
        l3.addAll(l1);
        l1.add(5L);
        print(l2);
        print(l3);
    }

    public static void print(List<Long> list) {
        for (Long s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
