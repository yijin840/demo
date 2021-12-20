package org.wys.demo.design.strategy;

import org.wys.demo.design.strategy.dict.CalculateDict;
import org.springframework.stereotype.Component;

/**
 * @author: wys
 * @Date: 2021/7/19
 */
@Component
public class AddCalculateStrategy extends AbstractCalculateStrategy{

    @Override
    public String getType() {
        return CalculateDict.ADD;
    }

    @Override
    public void calculate(int a, int b) {
        result = a + b;
    }
}
