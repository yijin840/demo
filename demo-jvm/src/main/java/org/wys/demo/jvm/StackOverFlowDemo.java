package org.wys.demo.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wys
 * @date 2021/11/29
 */
public class StackOverFlowDemo {

    public static void main(String[] args) {
        A a = new A();
        ALine aLine = new ALine();
        a.id = 1L;
        a.list = new ArrayList<>();
        a.list.add(aLine);
        aLine.id = 1L;
        aLine.a = a;
        System.out.println(aLine);
    }

    static class A {
       private Long id;
       private List<ALine> list;
    }

    static class ALine {
        private A a;
        private Long id;
    }
}
