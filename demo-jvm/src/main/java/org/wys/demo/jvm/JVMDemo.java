package org.wys.demo.jvm;

/**
 * @author wys
 * @date 2021/9/8
 */
public class JVMDemo {

    public static void main(String[] args) {
//        sof();
        oom();
    }

    private static void sof() {
        sof();
    }

    private static void oom() {
        while(true) {
            new Thread(()->{
                byte[] bytes = new byte[1024 * 1024 * 1024];
            }).start();
        }
    }


}
