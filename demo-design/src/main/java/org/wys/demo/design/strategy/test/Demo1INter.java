package org.wys.demo.design.strategy.test;

import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2020/9/29 4:55 下午
 */
@Component
public class Demo1INter implements TestInter {
    @Override
    public String type() {
        return "1";
    }

    @Override
    public void test() {

    }
}
