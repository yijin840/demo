package org.wys.demo.design.strategy.common;

/**
 * @author wys
 * @date 2021/7/19
 */
public class SubtractCalculateStrategy implements CalculateStrategy{

    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
