//package org.wys.demo.common.utils;
//
//import com.google.common.base.Throwables;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections.CollectionUtils;
//import org.redisson.Redisson;
//import org.redisson.api.RFuture;
//import org.redisson.api.RScript;
//import org.redisson.api.RedissonClient;
//import org.redisson.client.protocol.RedisCommands;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.concurrent.ExecutionException;
//
//import static org.redisson.api.RScript.Mode.READ_ONLY;
//
///**
// * @author wys
// * @date 2021/11/23
// */
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class RedisUtil {
//
//    private final RedissonClient redisson;
//
//    /**
//     * 设置参数
//     * @param key key
//     * @param value value
//     */
//    public void set(String key, String value) {
//        redisson.getBucket(key).set(value);
//    }
//
//    /**
//     * 设置参数获取返回值
//     * @param key key
//     * @return 返回值
//     */
//    public String get(String key) {
//        return redisson.getBucket(key).get().toString();
//    }
//
//    public void lock(String key) {
//        redisson.getFairLock(key).lock();
//    }
//
//    public void unlock(String key) {
//        redisson.getFairLock(key).unlock();
//    }
//
//    /**
//     * 执行script脚本
//     * @param script 脚本
//     * @param args 参数
//     */
//    public Object executeScript(String script, String...args) throws ExecutionException, InterruptedException {
//        redisson.getBucket("1").set("123");
//        RScript rScript = redisson.getScript();
//        String res = rScript.scriptLoad(script);
//        log.info("rScript result ===> {}", res);
//        log.info("rScript script ===> {}", script);
//        String obj = rScript.evalSha(READ_ONLY, res, RScript.ReturnType.VALUE);
//        log.info("RFuture res ==> {}", obj);
//        return null;
//    }
//}
