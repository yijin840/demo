package org.wys.demo.thread;

/**
 * @author wys
 * @date 2022/3/25
 */
public class VolatileMain {

    private volatile int num = 0;

    public void increase() {
        num++;
    }

    public static void main(String[] args) {
        VolatileMain volatileMain = new VolatileMain();
        for(int i=0;i<10;i++) {
            new Thread(()->{
                for(int j=1;j<=100;j++) {
                    volatileMain.increase();
                }
            }, "a" + i).start();
        }
        if(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(volatileMain.num);
    }

}
