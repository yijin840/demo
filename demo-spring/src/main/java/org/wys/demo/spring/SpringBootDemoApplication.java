package org.wys.demo.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.wys.demo.spring.config.MyConfiguration;
import org.wys.demo.design.strategy.CalculateHandler;
import org.wys.demo.spring.listen.UserEvent;
import org.wys.demo.spring.listen.UserPublish;
import org.wys.demo.spring.publish.EventManager;
import org.wys.demo.spring.publish.event.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.wys.demo.spring.service.MyService;
import org.wys.demo.test.RedisTest;

import java.util.List;


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
//@EnableDiscoveryClient
@EnableWebMvc
public class SpringBootDemoApplication implements ApplicationRunner {

    private final MyConfiguration myConfiguration;
    private final CalculateHandler calculateHandler;
    private final ApplicationContext applicationContext;
    private final UserService userService;
    private final RedisTest redisTest;
    private final List<StrategyDemo> strategyDemoList;
    private final UserPublish userPublish;
    private final MyService myService;
    private final EventManager eventManager;

    public static void main(String[] args) {
//        NamesrvStartup.main(args);
//        BrokerStartup.main(args);
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        strategyDemoList.forEach(item-> System.out.println(item.getType()));
        redisTest.script();
        userService.register("龙哥");
        userPublish.addUser(new UserEvent("object", "aaa","bbb"));
        eventManager.doHandler();
        myService.doHandler();
    }


}



