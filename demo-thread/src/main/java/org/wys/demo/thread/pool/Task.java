package org.wys.demo.thread.pool;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.concurrent.CountDownLatch;

/**
 * @author wys
 * @date 2021/6/29 4:52 下午
 */
@Component
@RequiredArgsConstructor
public class Task {

    private final AsyncExecute asyncExecute;
    private final CountDownLatch countDownLatch = new CountDownLatch(3);

    public void currentTask() {
        asyncExecute.executeTask(()->{
            System.out.println(Thread.currentThread().getName());
            for(int i=0;i<10;i++) {
                System.out.println(i);
            }
        });
        asyncExecute.executeTask(()->{
            System.out.println(Thread.currentThread().getName());
            for(int i=10;i<20;i++) {
                Thread.sleep(500);
                System.out.println(i);
            }
        });
        asyncExecute.executeTask(()->{
            System.out.println(Thread.currentThread().getName());
            for(int i=20;i<30;i++) {
                Thread.sleep(500);
                System.out.println(i);
            }
        });
    }
}
