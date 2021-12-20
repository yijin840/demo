package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 * 屏幕
 */
public class Screen extends Fitting{

    public Screen(Mobile mobile) {
        super(mobile);
    }

    @Override
    public String getName() {
        return mobile.getName() + "加了块屏幕";
    }

    @Override
    public int getPrice() {
        return mobile.getPrice() + 1000;
    }
}
