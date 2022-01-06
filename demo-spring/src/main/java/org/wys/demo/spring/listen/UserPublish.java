package org.wys.demo.spring.listen;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2022/1/6
 */
@Component
@RequiredArgsConstructor
public class UserPublish {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void addUser(UserEvent userEvent) {
        applicationEventPublisher.publishEvent(userEvent);
    }
}
