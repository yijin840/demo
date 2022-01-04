package org.wys.demo.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wys.demo.spring.child.EventHandler;

/**
 * @author wys
 * @date 2021/12/31
 */
public abstract class StrategyDemo {

    protected EventHandler eventHandler;

    @Autowired
    protected void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract String getType();

}




