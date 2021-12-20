package org.wys.demo.design.decoration.origin;

/**
 * @author wys
 * @date 2020/11/11 3:03 下午
 */
public class Main {
    public static void main(String[] args) {
        Phone phone = new MiPhone();
        System.out.println(phone.getName()+", "+phone.getPrice());
        Decorator miDecorator = new AddBigScreenDecorator(phone);
        System.out.println(miDecorator.getName()+", "+miDecorator.getPrice());
    }
}
