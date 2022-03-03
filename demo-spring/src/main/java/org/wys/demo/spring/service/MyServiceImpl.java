package org.wys.demo.spring.service;

import org.springframework.stereotype.Service;

/**
 * @author wys
 * @date 2022/1/7
 */
@Service("myService")
public class MyServiceImpl implements MyService {

    @Override
    public void doHandler() {
        System.out.println("============我是实现类==========");
    }
}
