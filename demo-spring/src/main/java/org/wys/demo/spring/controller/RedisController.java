package org.wys.demo.spring.controller;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wys.demo.common.utils.RedisUtil;
import org.wys.demo.spring.config.MyConfiguration;
import org.wys.demo.spring.service.MyService;

/**
 * @author wys
 * @date 2021/12/29
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/redis")
public class RedisController {

    private final Redisson redisson;
    private final RedisUtil redisUtil;
    private final MyConfiguration myConfiguration;
//    private final MyService myService;

    @GetMapping("/batchInsertData")
    public String batchInsertData() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 100; i++) {
            redisUtil.set("name" + i, String.valueOf(i));
        }
        stopWatch.stop();
        return "success. total time: " + stopWatch.getTotalTimeMillis();
    }

}
