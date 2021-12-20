package org.wys.demo.spring.event;

import org.wys.demo.spring.event.request.EventRequest;
import org.wys.demo.spring.event.service.IEventHandlerServiceLoader;

/**
 * @author wys
 * @date 2021/9/8
 */
public class Main {
    public static void main(String[] args) {
        IEventHandlerServiceLoader loader = new IEventHandlerServiceLoader();
        EventRequest request = new EventRequest();
    }
}
