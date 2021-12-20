package org.wys.demo.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5
                ,5
                ,1
                , TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(()->{

        });
    }
}
