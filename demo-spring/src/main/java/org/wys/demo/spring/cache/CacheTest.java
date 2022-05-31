//package org.wys.demo.spring.cache;
//
//import lombok.Data;
//
//import java.util.Objects;
//
///**
// * @author wys
// * @date 2022/5/31
// */
//public class CacheTest {
//
//    public static void main(String[] args) {
//        BeanTest beanTest = new BeanTest();
//        beanTest.setName("123");
//        BeanLocalCache<BeanTest> beanLocalCache = new BeanLocalCache<>();
//        beanLocalCache.set("test", beanTest);
//        BeanTest o = beanLocalCache.get("test");
//        System.out.println(o.getName());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        o = beanLocalCache.get("test");
//        if(Objects.nonNull(o)) {
//            System.out.println(o.getName());
//        } else {
//            System.out.println("找不到key");
//        }
//    }
//
//    @CacheBean(value = BeanTest.class)
//    @Data
//    static class BeanTest {
//        private String name;
//    }
//
//}
