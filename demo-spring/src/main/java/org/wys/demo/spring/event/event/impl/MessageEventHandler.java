package org.wys.demo.spring.event.event.impl;

import org.wys.demo.spring.event.request.EventRequest;
import org.wys.demo.spring.event.event.IEventHandler;

/**
 * @author wys
 * @date 2021/9/8
 */
public class MessageEventHandler implements IEventHandler {

    @Override
    public void handleEvent(EventRequest request) {
        sendMessage();
    }

    private void sendMessage() {

    }
}
