package org.wys.demo.test;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.wys.demo.common.bean.Currency;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author wys
 * @date 2021/12/20
 */
public class NullTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Currency currency = new Currency();
//        Method[] methods = currency.getClass().getMethods();
//        for (Method method : methods) {
//            if(method.getName().startsWith("set") && method.getName().endsWith("Value")) {
//                Arrays.stream(method.getParameterTypes()).forEach(System.out::println);
//                method.invoke(currency,new BigDecimal("1"));
//                break;
//            }
//        }
        System.out.println(currency);
    }
}
