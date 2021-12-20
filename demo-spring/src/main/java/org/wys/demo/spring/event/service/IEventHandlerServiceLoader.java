package org.wys.demo.spring.event.service;

import org.wys.demo.spring.event.event.IEventHandler;
import org.wys.demo.spring.event.event.impl.MessageEventHandler;
import org.wys.demo.spring.event.request.EventRequest;

import java.util.Objects;

/**
 * @author wys
 * @date 2021/9/8
 */
public class IEventHandlerServiceLoader {

    public void loadEvent(EventRequest request) {
        choose(request).handleEvent(request);
    }
    private IEventHandler choose(EventRequest request) {
        if(Objects.nonNull(request) && Objects.nonNull(request.getCompany())) {
            if(Objects.equals(request.getCompany(), "123")) {
                return new MessageEventHandler();
            }
        }
        throw new RuntimeException("没有找到合适的公司！");
    }
}
