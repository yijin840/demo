package org.wys.demo.test;

import okhttp3.Cache;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wys
 * @date 2021/12/13
 */
public class StaticTest {

    public static void main(String[] args) {
        A.print();
        for(Method method : A.class.getMethods()) {
            System.out.println(method.getName());
        }
        Map<String, Method> methodMap = Arrays.stream(A.class.getDeclaredMethods()).collect(Collectors.toMap(Method::getName, method -> method));
        methodMap.forEach((key,value)->{
            System.out.println(key+":"+value);
        });
    }

    static class A {

        private static final Map<String, String> map;

        static {
            map = new HashMap<>();

        }
        public static void print() {
            map.put("1","1");
            map.forEach((key,value)->{
                System.out.println(key);
            });
        }
        public static void a() {

        }
        public static void b() {

        }

    }

}
