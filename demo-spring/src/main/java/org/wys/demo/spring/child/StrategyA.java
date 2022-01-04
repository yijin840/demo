package org.wys.demo.spring.child;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.wys.demo.spring.StrategyDemo;

/**
 * @author wys
 * @date 2021/12/31
 */
@Component
public class StrategyA extends StrategyDemo {
    @Override
    public String getType() {
        System.out.println(eventHandler.get());
        return "A";
    }

}
