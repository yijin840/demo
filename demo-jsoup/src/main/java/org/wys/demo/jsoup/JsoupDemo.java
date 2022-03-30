package org.wys.demo.jsoup;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wys
 * @date 2021/9/7
 */
@Slf4j
public class JsoupDemo {
    private static final String URL = "http://30.43.48.249:8888/export/pdf";
    private static final Lock lock = new ReentrantLock();
    private static final Map<Thread, Integer> map = new ConcurrentHashMap<>();
    private static volatile AtomicInteger max_value = new AtomicInteger(0);

    private static volatile int number = 0;
    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i <= 1000; i++) {
            Thread thread = new Thread(JsoupDemo::run, String.valueOf(i));
            thread.start();
            if(i <= 2) {
                Thread.sleep(1000);
            }
            thread.join();
        }
    }

    public static void run() {
        try {
            System.out.println(max_value.getAndIncrement());
            Document document = Jsoup.connect(URL).ignoreContentType(true).get();
//            System.out.println("当前线程"+name+"已经启动");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
