package org.wys.demo.test.str;

/**
 * @author wys
 * @date 2022/4/13
 */
public class StrTest {

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "b";
        System.out.println("=======main swap before========");
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
        swap(s1, s2);
        System.out.println("=======main swap after========");
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
    }

    public static void swap(String s1, String s2) {
        String temp = s1;
        s1 = s2;
        s2 = temp;
        System.out.println("=======swapping========");
        System.out.println("s1 : " + s1);
        System.out.println("s2 : " + s2);
    }

}
