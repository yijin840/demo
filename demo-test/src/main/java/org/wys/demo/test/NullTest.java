package org.wys.demo.test;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.NotNull;
import org.wys.demo.common.bean.Currency;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2021/12/20
 */
public class NullTest {

    public static void main(String[] args) {
        Currency currency = new Currency();
        currency.intValue(new BigDecimal("123"));
        System.out.println(currency.getValue());
    }
}
