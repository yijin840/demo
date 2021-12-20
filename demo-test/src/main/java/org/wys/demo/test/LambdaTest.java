package org.wys.demo.test;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wys
 * @date 2021/12/3
 */
public class LambdaTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        map.put("b", null);
        System.out.println(map.containsKey("b"));

        A a = new A();
        a.setA("123");
        System.out.println(a.a);
        setA(a);
        System.out.println(a.a);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("aaaa");
        System.out.println(stringBuilder.length());

    }
    public static void setA(A a) {
        a.setA("233");
        System.out.println(a.a);
    }

    @Data
    static class A {
        private String a;
    }
}
