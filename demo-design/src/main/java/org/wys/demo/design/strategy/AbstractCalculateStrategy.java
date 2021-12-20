package org.wys.demo.design.strategy;


/**
 * @author wys
 * @Date 2021.07.19
 */
public abstract class AbstractCalculateStrategy implements CalculateStrategy{

    protected int result = 0;

    /**
     * 获取结果
     * @return
     */
    public int getResult() {
        return result;
    }

    abstract public String getType();

}
