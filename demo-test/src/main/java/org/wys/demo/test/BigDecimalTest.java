package org.wys.demo.test;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2022/5/20
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        double d = 0.1d;
        float f = 0.1f;
        System.out.println(BigDecimal.valueOf(d));
        System.out.println(BigDecimal.valueOf(f));
        System.out.println(new BigDecimal("0.1"));
    }
}
