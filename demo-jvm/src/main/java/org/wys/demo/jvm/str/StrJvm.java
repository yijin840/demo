package org.wys.demo.jvm.str;

/**
 * @author wys
 * @date 2022/4/13
 */
public class StrJvm {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = new String("aaa");
        String s3 = "bbb";
        s1 = s3;
        s2 = s3;
//        System.gc();
        while(true) {

        }
    }
}
