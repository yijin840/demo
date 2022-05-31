package org.wys.demo.spring.cache;

import cn.hutool.core.date.LocalDateTimeUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wys
 * @date 2022/5/31
 */
@Component
public class BeanLocalCache<T> implements LocalCache<T> {

    private final Map<String, BeanProperty<T>> CACHE = new ConcurrentHashMap<>();

    @Override
    public T get(String key) {
        BeanProperty<T> beanProperty = CACHE.get(key);
        if(Objects.isNull(beanProperty)) {
            return null;
        }
        if(beanProperty.getEndTime().compareTo(LocalDateTime.now()) < 0) {
            CACHE.remove(key);
            return null;
        }
        return CACHE.get(key).getBean();
    }

    @Override
    public void set(String key, T value) {
        BeanProperty<T> beanProperty = new BeanProperty<>();
        beanProperty.setBean(value);
        beanProperty.setStartTime(LocalDateTime.now());
        beanProperty.setEndTime(LocalCacheUtil.getDefaultEndTime());
        beanProperty.setCacheStrategy(LocalCacheUtil.getCacheStrategy(value));
        CACHE.put(key, beanProperty);
    }

    @Override
    public void setExpire(String key, TimeUnit unit, int t) {
        BeanProperty<T> beanProperty = CACHE.get(key);
        if(Objects.nonNull(beanProperty)) {
            beanProperty.setEndTime(beanProperty.getStartTime().plusSeconds(unit.toSeconds(t)));
        }
        CACHE.put(key, beanProperty);
    }
}
