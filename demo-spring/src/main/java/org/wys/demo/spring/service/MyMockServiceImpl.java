package org.wys.demo.spring.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author wys
 * @date 2022/1/7
 */
@ConditionalOnMissingBean
public class MyMockServiceImpl implements MyService {
    @Override
    public void doHandler() {
        System.out.println("========我是mock的==========");
    }
}
