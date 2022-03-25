package org.wys.demo.thread.async;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.var;

import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * @author wys
 * @date 2022/3/23
 */
public class FutureTaskDemo {

    private final ExecutorService executor = new ThreadPoolExecutor(5,
            5,
            1,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTaskDemo demo = new FutureTaskDemo();
        CountDownLatch count = new CountDownLatch(2);
        Integer f1 = demo.asyncExecute(count, () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            count.countDown();
            return sum;
        });
        Integer f2 = demo.asyncExecute(count, () -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            count.countDown();
            return sum;
        });
        count.await();
        System.out.println(f1 + f2);
    }

    private <T> T asyncExecute(CountDownLatch latch, Supplier<T> supplier) throws ExecutionException, InterruptedException {
        Future<T> future = executor.submit(() -> {
            latch.countDown();
            return supplier.get();
        });
        return future.get();
    }

}
