package org.wys.demo.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author wys
 * @date 2022/4/21
 */
public class ListTest {

    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        B b1 = new B();
        C b2 = new C();
        list.add((A) b1);
        print(list);
        HashMap<String ,String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            B o = (B) list.get(i);
            System.out.println(o.a);
        }
    }

    public static void print(List<? extends A> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    static class A {
        int a = 0;
    }

    static class B extends A {

    }

    static class C extends A {

    }

}
