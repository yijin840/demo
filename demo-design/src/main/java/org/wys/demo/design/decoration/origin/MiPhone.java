package org.wys.demo.design.decoration.origin;

/**
 * @author wys
 * @date 2020/11/11 2:57 下午
 */
public class MiPhone implements Phone {

    @Override
    public String getName() {
        return "小米手机";
    }

    @Override
    public Long getPrice() {
        return 2000L;
    }
}
