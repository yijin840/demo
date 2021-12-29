package org.wys.demo.spring.controller;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wys.demo.common.utils.RedisUtil;

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

    @GetMapping("/batchInsertData")
    public String batchInsertData() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            redisUtil.set("name" + i, String.valueOf(i));
        }
        stopWatch.stop();
        return "success. total time: " + stopWatch.getTotalTimeMillis();
    }

}
