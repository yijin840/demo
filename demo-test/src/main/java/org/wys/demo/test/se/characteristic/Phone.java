package org.wys.demo.test.se.characteristic;

import java.math.BigDecimal;

/**
 * @author wys
 * @date 2021/1/12 5:46 下午
 */
public class Phone {

    private String name;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "name:"+this.getName()+"price:"+this.getPrice();
    }
}
