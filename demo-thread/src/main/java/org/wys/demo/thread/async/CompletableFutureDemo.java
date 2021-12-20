package org.wys.demo.thread.async;

import java.util.concurrent.CompletableFuture;

/**
 * @author wys
 * @date 2021/9/8
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
            return sum;
        });
        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            System.out.println(2);
            return sum;
        });
        int sum = c1.join() + c2.join();
        CompletableFuture<Void> voidCompletableFuture = c1.thenAccept(System.out::println);
        System.out.println(sum);
    }
}
