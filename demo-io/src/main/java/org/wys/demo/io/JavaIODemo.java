package org.wys.demo.io;

import java.io.*;

/**
 * @author wys
 * @date 2022/4/22
 */
public class JavaIODemo {

    public static void main(String[] args) {
        String str = "a";
        LL:
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                continue LL;
            }
            System.out.println(i);
        }


    }

}
