package org.wys.demo.thread.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wys
 * @date 2021/6/29 4:10 下午
 * 线程池配置
 */
@Component
@Slf4j
@EnableAsync
public class ThreadPoolConfiguration {


    @Bean("threadPoolTaskExecutor")
    public Executor getThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setQueueCapacity(100);
        threadPoolTaskExecutor.setThreadNamePrefix("demo");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolTaskExecutor.initialize();
        log.info("线程池初始化成功");
        return threadPoolTaskExecutor;
    }

}
