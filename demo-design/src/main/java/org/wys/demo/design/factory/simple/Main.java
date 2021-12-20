package org.wys.demo.design.factory.simple;

/**
 * @author wys
 * @date 2020/11/16 10:02 上午
 */
public class Main {
    public static void main(String[] args) {

        Phone phone = PhoneFactory.getPhone("Iphone");
        phone.getName();
    }
}
