package org.wys.demo.test;

import lombok.var;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author wys
 * @date 2022/3/25
 */
public class LombokMain {

    public static void main(String[] args) {
        var str = "string";
        var list = new ArrayList<>();
        list.add(new BigDecimal("123"));
        list.add("233");
        System.out.println(str);
        list.forEach(System.out::println);
    }

}
