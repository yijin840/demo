package org.wys.demo.spring;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author wys
 * @date 2021/1/14 10:06 上午
 */
@Slf4j
public class SpringCanonCustomApplicationInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {
    @Override
    public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
        // 初始化动作
        log.info("初始化开始====>{}", configurableApplicationContext);
    }
}
