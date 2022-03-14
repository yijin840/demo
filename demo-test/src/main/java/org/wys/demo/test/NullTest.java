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

    public static void main(String[] args) {
        Model model = new Model();
        System.out.println(model.getA());
        System.out.println(model.isSuccess());
    }
    @Data
    static class Model {
        private int a;
        private boolean isSuccess;
    }
}
