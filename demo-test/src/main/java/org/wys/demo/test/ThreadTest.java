package org.wys.demo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wys
 * @date 2022/3/16
 */
public class ThreadTest {

    private final List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.list.add("123");
        for(int i=0;i<100;i++) {
            final String ss = String.valueOf(i);
            new Thread(()->{
                threadTest.list.add(ss);
            },String.valueOf(i)).start();
        }
        for(int i=0;i<100;i++) {
            System.out.println(threadTest.list.get(i));
        }
    }

}
