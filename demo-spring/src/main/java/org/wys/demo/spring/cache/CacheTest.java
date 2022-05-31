package org.wys.demo.spring.cache;

import lombok.Data;

/**
 * @author wys
 * @date 2022/5/31
 */
public class CacheTest {

    public static void main(String[] args) {
        BeanTest beanTest = new BeanTest();
        beanTest.setName("123");
        BeanLocalCache beanLocalCache = new BeanLocalCache();
        beanLocalCache.set("test", beanTest);
    }

    @CacheBean(value = BeanTest.class)
    @Data
    static class BeanTest {
        private String name;
    }

}
