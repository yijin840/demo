package org.wys.demo.spring.event.event;

import org.wys.demo.spring.event.request.EventRequest;

/**
 * @author wys
 * @date 2021/9/8
 */
public interface IEventHandler {

    /**
     * 处理事件
     * @param request 入参
     */
    void handleEvent(EventRequest request);

}
