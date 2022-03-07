package org.wys.demo.spring.publish.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @author wys
 * @date 2021/9/8
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String username) {
        log.info("【 register 】 执行用户 {} 注册", username);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this,username));
    }


}
