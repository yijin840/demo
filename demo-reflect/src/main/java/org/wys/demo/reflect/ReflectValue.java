package org.wys.demo.reflect;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * @author wys
 * @date 2021/12/10
 */
@Slf4j
public class ReflectValue {

    public static void main(String[] args) {
        A a = new A();
//        setValue(a, "amount", new Currency(BigDecimal.valueOf(123.123)));
//        log.info("a ===> {}", a);

        Method[] methods = a.getClass().getDeclaredMethods();
        for(Method method : methods) {
            System.out.println(method.getName());
            if(method.getName().equals("print")) {
                try {
                    method.setAccessible(true);
                    method.invoke(a);
                    method.setAccessible(false);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void setValue(A a, String fieldName, Object value) {
        Method[] methods = a.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("set") && method.getName().endsWith(fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1))) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> parameterType = parameterTypes[0];
                if(parameterType.getTypeName().equals(Currency.class.getName())) {
                    try {
                        method.invoke(a, value);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Data
    static class Currency {
        private BigDecimal amount;
        public Currency(BigDecimal amount) {
            this.amount = amount;
        }
    }

    @Data
    static class A {
        private String name;
        private Currency amount;
        private static void print() {
            System.out.println("123");
        }

    }

}
