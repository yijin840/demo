package org.wys.demo.common.utils;

import lombok.RequiredArgsConstructor;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

/**
 * @author wys
 * @date 2021/11/23
 */
@Component
@RequiredArgsConstructor
public class RedisUtil {

    private final Redisson redisson;

    public void set(String key, String value) {
        redisson.getBucket(key).set(value);
    }

    public String get(String key) {
        return redisson.getBucket(key).get().toString();
    }

    public void lock(String key) {
        redisson.getFairLock(key).lock();
    }

    public void unlock(String key) {
        redisson.getFairLock(key).unlock();
    }
}
