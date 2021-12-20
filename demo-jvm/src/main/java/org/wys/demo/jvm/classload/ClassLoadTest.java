package org.wys.demo.jvm.classload;

/**
 * @author wys
 * @date 2021/9/1
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        //三大间接引用，类不会被加载
        System.out.println(B.a);
        System.out.println(B.aa);
        B[] bs = new B[1024];
    }

    public static class A {

        public static final String a = "a";
        public static String aa = "aa";

        static {
            System.out.println("static aaa");
        }
    }

    public static class B extends A{
        public static final String b = "b";
        public static String bb = "bb";

        static {
            System.out.println("static bbb");
        }
    }
}
