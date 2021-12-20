package org.wys.demo.design.strategy.test;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wys
 * @date 2020/9/29 4:56 下午
 */
@Component
public class Test implements InitializingBean{

    @Autowired
    private List<TestInter> testInterList;

    public void test() {
        testInterList.stream().forEach(val->{
            System.out.println(val.type());
        });
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        test();
    }
}
