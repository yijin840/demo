package org.wys.demo.common.bean;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @author wys
 * @date 2021/12/20
 */
@Data
public class Currency {

    @NotNull
    private BigDecimal value;

    public Currency() {
    }

    public Currency(BigDecimal var) {
        this.value = var;
    }


    public Currency(double var) {
        this(new BigDecimal(var));
    }

    public Currency(int var) {
        this(new BigDecimal(var));
    }

    public Currency(long var) {
        this(new BigDecimal(var));
    }

    public int compareTo(BigDecimal var) {
        return this.value.compareTo(var);
    }

    public int compareTo(Currency currency) {
        return this.value.compareTo(currency.getValue());
    }

    public double doubleValue(BigDecimal var) {
        return var.doubleValue();

    }

    public float floatValue(BigDecimal var) {
        return var.floatValue();
    }

    public long longValue(BigDecimal var) {
        return var.longValue();
    }

    public int intValue(BigDecimal var) {
        return var.intValue();
    }
}