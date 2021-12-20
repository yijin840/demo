package org.wys.demo.design.observer;


import lombok.extern.slf4j.Slf4j;

/**
 * @author wys
 * @date 2021/7/7 11:10 上午
 */
@Slf4j
public class ObserverSpecific implements Observer{

    @Override
    public void response(Object obj) {
        if(obj instanceof Integer) {
            log.info("变化了{}", obj);
        }
    }
}
