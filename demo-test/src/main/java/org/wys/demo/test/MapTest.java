package org.wys.demo.test;

import javax.xml.crypto.Data;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author wys
 * @date 2022/4/22
 */
public class MapTest {
    private final static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5
            , 5
            , 1
            , TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(5)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException, ParseException {
//        Map<String, String> map = new HashMap<>();
//        map.put(null,null);
//        System.out.println(map.get(null));
//        Map<String,String> table = new Hashtable<>();
//        table.put(null,null);
//        System.out.println(table.get(null));
        Map<String, String> m1 = new HashMap<>(3);
        int l = 0;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = dateFormat.parse("2021-08-05 09:47:01");
        System.out.println(parse);
        while(l <= 10) {
            threadPoolExecutor.submit(() -> {
                m1.put("a","a");
            }).get();
            threadPoolExecutor.submit(() -> {
                m1.put("a", "b");
            }).get();
            System.out.println(m1.get("a"));
            l++;
        }
        threadPoolExecutor.shutdown();

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
