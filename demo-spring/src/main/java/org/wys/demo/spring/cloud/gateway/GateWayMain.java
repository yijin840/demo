package org.wys.demo.spring.cloud.gateway;

/**
 * @author wys
 * @date 2022/2/14
 */
public class GateWayMain {
    public static void main(String[] args) {
        Integer integer = 1;
        Integer integer1 = 2;
        synchronized (integer) {
            System.out.println("123");
        }
        synchronized (integer1) {
            System.out.println("23433");
        }
    }
}
