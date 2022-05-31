package org.wys.demo.spring.cache;

import java.util.concurrent.TimeUnit;

/**
 * @author wys
 * @date 2022/5/31
 */
public interface LocalCache<T> {

    /**
     * 获取缓存
     * @param key 缓存key
     * @return 返回当前缓存的值
     */
    T get(String key);

    /**
     * 设置本地缓存
     * @param key 缓存key
     * @param value 缓存value
     */
    void set(String key, T value);

    /**
     * 缓存失效时间
     * @param key 缓存key
     * @param t 失效时间
     * @param unit 单位
     */
    void setExpire(String key, TimeUnit unit, int t);
}
