package org.wys.demo.thread.bw;

/**
 * ClassName TestOne
 * Package org.wys.demo.thread.bw
 * Description
 *
 * @author wys
 * @date 2022/6/13 16:13
 */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.*;

public class ShowMeBug {

    private static boolean enable = true;
    private static final ExecutorService notifiedService = new ThreadPoolExecutor(5
            , 10
            , 1000L
            , TimeUnit.SECONDS
            , new ArrayBlockingQueue<>(10)
            , Executors.defaultThreadFactory()
            , new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
//         MsgNotice.sendMessage("http://www.baidu.com", "json");
    }

    private static class MsgNotice {
        public static void sendMessage(String url, String message) {
            if (!enable) {
                return;
            }
            CompletionService<String> completionService = new ExecutorCompletionService<>(notifiedService);
            Future<String> submit = completionService.submit(() -> {
                        String result = null;
                        try {
                            result = doPost(url, message);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return result;
                    }
            );
            try {
                submit.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        private static String doPost(String httpUrl, String param) {
            HttpURLConnection connection = null;
            String result = null;
            try {
                URL url = new URL(httpUrl);
                // 通过远程url连接对象打开连接
                connection = (HttpURLConnection) url.openConnection();
                // 设置连接请求方式
                connection.setRequestMethod("POST");
                // 设置传入参数
                connection.setRequestProperty("Content-Type", "application/json");
                // 通过连接对象获取一个输出流
                try (OutputStream os = connection.getOutputStream()) {
                    // 通过输出流对象将参数写出去/传输出去,它是通过字节数组写出的
                    os.write(param.getBytes());
                    os.flush();
                    // 通过连接对象获取一个输入流，读取数据
                    if (connection.getResponseCode() == 200) {
                        try (InputStream is = connection.getInputStream();
                             BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                            StringBuilder sbf = new StringBuilder();
                            String temp = null;
                            while ((temp = br.readLine()) != null) {
                                sbf.append(temp);
                                sbf.append("\r\n");
                            }
                            result = sbf.toString();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != connection) {
                    connection.disconnect();
                }
            }
            return result;
        }
    }
}


