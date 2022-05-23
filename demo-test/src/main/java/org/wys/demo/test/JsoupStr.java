package org.wys.demo.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class JsoupStr {
    public static void main(String[] args) throws IOException {
        //websocket协议
        System.setProperty("http.proxyHost", "117.164.185.134");
        System.setProperty("http.proxyPort", "52350");
        String url = "ws://localhost:8080/websocket/websocket";
        URLConnection urlConnection = new URL(url).openConnection();
        urlConnection.setRequestProperty("Upgrade","websocket");
        InputStream inputStream = urlConnection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bufferedInputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }

        bufferedInputStream.close();
        inputStream.close();
    }
}
