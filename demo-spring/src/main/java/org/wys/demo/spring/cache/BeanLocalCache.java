package org.wys.demo.spring.cache;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wys
 * @date 2022/5/31
 */
@Component
public class BeanLocalCache implements LocalCache<Object> {

    private final Map<String, BeanProperty> CACHE = new ConcurrentHashMap<>();

    @Override
    public Object get(String key) {
        return CACHE.get(key);
    }

    @Override
    public void set(String key, Object value) {
        BeanProperty beanProperty = new BeanProperty();
        beanProperty.setBean(value);
        beanProperty.setStartTime(LocalDateTime.now());
        beanProperty.setCacheStrategy(LocalCacheUtil.getCacheStrategy(value));
        CACHE.put(key, beanProperty);
    }

    @Override
    public void setExpire(String key, TimeUnit t) {

    }
}
