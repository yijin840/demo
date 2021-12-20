package org.wys.demo.http.okhttp;

import okhttp3.*;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.internal.Throwables;
import org.springframework.util.StopWatch;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wys
 * @date 2021/11/6
 */
public class OkHttpDemo {

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5,
            5,
            1,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws IOException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Document document = Jsoup.connect("https://www.baidu.com").get();
        stopWatch.stop();
        System.out.println("jsoup get : " + stopWatch.getTotalTimeMillis());

        StopWatch s1 = new StopWatch();
        s1.start();
        OkHttpClient okHttpClient = new OkHttpClient.Builder().callTimeout(3L, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url("https://www.baidu.com")
                .get()
                .build();
        Call call = okHttpClient.newCall(request);
        call.execute();
        s1.stop();
        System.out.println("okhttp get: " + s1.getTotalTimeMillis());

        StopWatch s2 = new StopWatch();
        s2.start();
        HttpGet httpGet = new HttpGet("https://www.baidu.com");
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpClient.execute(httpGet);
        s2.stop();
        System.out.println("http client get: " + s2.getTotalTimeMillis());

        StopWatch s3 = new StopWatch();
        s3.start();
        URL url = new URL("https://www.baidu.com");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        s3.stop();
        System.out.println("url connection get: " + s3.getTotalTimeMillis());

        SocketAdapter socketAdapter = new Android10SocketAdapter();
    }
}
