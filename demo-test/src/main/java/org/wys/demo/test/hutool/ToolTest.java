package org.wys.demo.test.hutool;

import cn.hutool.Hutool;
import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.LFUCache;

/**
 * @author wys
 * @date 2021/12/20
 */
public class ToolTest {

    public static void main(String[] args) {
        LFUCache<Object, Object> lfuCache = CacheUtil.newLFUCache(2);
        lfuCache.put("1","1");
        lfuCache.put("2","2");
        lfuCache.put("3","3");
        lfuCache.get("2");
        lfuCache.get("2");
        lfuCache.get("2");
        lfuCache.get("1");
        long count = lfuCache.getHitCount();
        lfuCache.forEach(System.out::println);
    }

}
