package org.wys.demo.thread;

import java.util.Map;

/**
 * @author wys
 * @date 2021/12/24
 * 线程路由
 */
public class RoutingRunnable implements Runnable {

    private final Runnable runnable;

    public RoutingRunnable(Runnable runnable) {
//        ThreadGroup group = Thread.currentThread().getThreadGroup();
//        Thread[] threadArray = new Thread[group.activeCount()];
//        group.enumerate(threadArray);
//        for(Thread thread : threadArray) {
//            System.out.println(thread.getName());
//        }
        this.runnable = runnable;
    }

    public static Runnable run(Runnable runnable) {
        return new RoutingRunnable(runnable);
    }

    @Override
    public void run() {
        this.runnable.run();
    }
}
