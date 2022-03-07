package org.wys.demo.spring.publish.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author wys
 * @date 2021/9/8
 */
@Service
@Slf4j
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("给用户 {} 发送邮件", event.getUsername());
    }
}
