package org.wys.demo.thread;

import org.elasticsearch.threadpool.ThreadPool;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wys
 * @date 2021/12/7
 */
public class ThreadTransactionalDemo {

    private static final ThreadPoolExecutor THREAD_POOL = new ThreadPoolExecutor(5
            , 10
            , 1000L
            , TimeUnit.SECONDS
            , new LinkedBlockingQueue<>()
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CountDownLatch count = new CountDownLatch(10);
        for(int i= 0;i< 10;i++) {
            int finalI = i;
            THREAD_POOL.execute(() -> {
                printOne(finalI);
                count.countDown();
            });
        }
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
        stopWatch.stop();
        System.out.println("线程池执行时间: " + stopWatch.getTotalTimeMillis());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<10;i++) {
            list.add(i);
        }
        stopWatch.start();
        list.parallelStream().forEach(ThreadTransactionalDemo::printOne);
        stopWatch.stop();
        System.out.println("并行流执行时间： " + stopWatch.getTotalTimeMillis());
    }

    public static void printOne(int i) {
        System.out.println(i);
    }
}
