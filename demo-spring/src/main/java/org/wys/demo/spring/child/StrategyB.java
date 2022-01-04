package org.wys.demo.spring.child;

import org.springframework.stereotype.Component;
import org.wys.demo.spring.StrategyDemo;

/**
 * @author wys
 * @date 2021/12/31
 */
@Component
public class StrategyB extends StrategyDemo {
    @Override
    public String getType() {
        return "B";
    }
}
