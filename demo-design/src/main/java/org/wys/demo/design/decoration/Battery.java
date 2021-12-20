package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 * 电池
 */
public class Battery extends Fitting{

    public Battery(Mobile mobile) {
        super(mobile);
    }

    @Override
    public String getName() {
        return mobile.getName()+"加了块大容量电池";
    }

    @Override
    public int getPrice() {
        return mobile.getPrice() + 800;
    }
}
