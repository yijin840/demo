package org.wys.demo.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolFutureTaskDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5
                ,5
                ,1
                , TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(5)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> futureResult = threadPoolExecutor.submit(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            return sum;
        });
        threadPoolExecutor.shutdown();
        try {
            System.out.println(futureResult.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
