package org.wys.demo.test;

/**
 * @author wys
 * @date 2021/12/24
 */
public class TestThreeCal {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        Integer result = (flag ?  a * b  :  c);
        System.out.println(result);
    }
}
