package org.wys.demo.spring.listen;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2022/1/6
 */
@Component
public class SpringListen implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        Object source = event.getSource();
        System.out.println("[ SpringListen ] ==> " + source);
    }
}
