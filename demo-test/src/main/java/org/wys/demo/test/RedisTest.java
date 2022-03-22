package org.wys.demo.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.wys.demo.common.utils.RedisUtil;

import java.util.concurrent.ExecutionException;

/**
 * @author wys
 * @date 2021/11/23
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RedisTest {

    private final RedisUtil redisUtil;

    public void test() {
        redisUtil.set("aaa","123456");
        String aaa = redisUtil.get("aaa");
        log.info("redisson get ====> key:{}, value:{}", "aaa", aaa);
    }

    public void script() throws ExecutionException, InterruptedException {
        String script = "return redis.call('get', '1')";
        log.info("redis script execute...");
        redisUtil.executeScript(script);
    }

}
