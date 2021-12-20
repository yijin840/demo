package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 */
public class MiMobile implements Mobile{

    @Override
    public String getName() {
        return "小米手机";
    }

    @Override
    public int getPrice() {
        return 1000;
    }
}
