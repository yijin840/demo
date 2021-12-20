package org.wys.demo.design.decoration;

/**
 * @author wys
 * @date 2021/7/19
 * 抽象配件类
 */
public abstract class Fitting implements Mobile{

    protected Mobile mobile;

    public Fitting(Mobile mobile) {
        super();
        this.mobile = mobile;
    }
}
