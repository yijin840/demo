package org.wys.demo.test;

/**
 * @author wys
 * @date 2022/5/6
 */
public class ClassLoad {

    public static void main(String[] args) {
        System.out.println(ClassLoad.class.getClassLoader().getClass().getClassLoader());
    }
}
