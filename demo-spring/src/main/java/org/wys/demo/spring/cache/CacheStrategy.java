package org.wys.demo.spring.cache;

/**
 * @author wys
 * @date 2022/5/31
 * 缓存失效策略
 */
public enum CacheStrategy {

    /**
     * 没有策略，默认的
     */
    NONE {
        @Override
        public Integer strategy() {
            return NONE_STRATEGY;
        }
    },
    /**
     * LRU， 淘汰最近未被使用的数据
     */
    LRU {
        @Override
        public Integer strategy() {
            return LRU_STRATEGY;
        }
    };
    public Integer strategy() {
        throw new RuntimeException("not strategy");
    }
    private final static Integer NONE_STRATEGY = 1;
    private final static Integer LRU_STRATEGY = 1;
}
