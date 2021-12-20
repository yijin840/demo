package org.wys.demo.design.strategy.test;

import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2020/9/29 4:55 下午
 */
@Component
public class Demo2Inter implements TestInter {
    @Override
    public String type() {
        return "2";
    }

    @Override
    public void test() {

    }
}
