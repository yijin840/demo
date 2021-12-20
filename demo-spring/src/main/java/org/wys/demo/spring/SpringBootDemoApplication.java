package org.wys.demo.spring;

import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.broker.BrokerController;
import org.apache.rocketmq.broker.BrokerStartup;
import org.apache.rocketmq.common.BrokerConfig;
import org.apache.rocketmq.namesrv.NamesrvStartup;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.FilterType;
import org.wys.demo.spring.condition.Test;
import org.wys.demo.spring.config.MyConfiguration;
import org.wys.demo.design.strategy.CalculateHandler;
import org.wys.demo.design.strategy.common.AddCalculateStrategy;
import org.wys.demo.design.strategy.common.CalculateStrategy;
import org.wys.demo.design.strategy.common.SubtractCalculateStrategy;
import org.wys.demo.design.strategy.dict.CalculateDict;
import org.wys.demo.design.strategy.request.CalculateRequest;
import org.wys.demo.spring.SpringCanonCustomApplicationInitializer;
import org.wys.demo.spring.publish.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.wys.demo.test.PostConstructorMain;
import org.wys.demo.test.RedisTest;


/**
 * @author wys
 */
@EnableConfigurationProperties(MyConfiguration.class)
@SpringBootApplication
@Slf4j
@EnableAsync
@ComponentScan(basePackages = {"org.wys.demo"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "org.wys.demo.mq*")
        })
@RequiredArgsConstructor
public class SpringBootDemoApplication implements ApplicationRunner {

    private final MyConfiguration myConfiguration;
    private final CalculateHandler calculateHandler;
    private final ApplicationContext applicationContext;
    private final UserService userService;
    private final RedisTest redisTest;

    public static void main(String[] args) {
//        NamesrvStartup.main(args);
//        BrokerStartup.main(args);
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        redisTest.test();
        userService.register("龙哥");
    }
}



