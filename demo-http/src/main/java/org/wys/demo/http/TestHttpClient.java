package org.wys.demo.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author wys
 * @date 2020/12/22 5:05 下午
 */
public class TestHttpClient {
    public void testHttpClient() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpUriRequest request = new HttpGet("https://www.baidu.com");
        HttpResponse response = client.execute(request);
        InputStream inputStream = response.getEntity().getContent();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null) {
            sb.append(temp).append('\n');
        }
        System.out.println(sb);
    }
}
