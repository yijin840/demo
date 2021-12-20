package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 */
public class IphoneMobile implements Mobile{
    @Override
    public String getName() {
        return "苹果手机";
    }

    @Override
    public int getPrice() {
        return 3000;
    }
}
