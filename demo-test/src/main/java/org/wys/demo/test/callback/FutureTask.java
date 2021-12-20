package org.wys.demo.test.callback;

import java.util.concurrent.*;

/**
 * @author wys
 * @date 2021/12/14
 */
public class FutureTask<V> {

    private ExecutorService executor = new ThreadPoolExecutor(5
            ,5
            ,1
            , TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(5)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.AbortPolicy());

    public V doWithTask(Callable<V> callable) {
        return callable.call();
    }

}
