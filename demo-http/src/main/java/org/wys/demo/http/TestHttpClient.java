package org.wys.demo.http;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.asynchttpclient.util.HttpUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wys
 * @date 2020/12/22 5:05 下午
 */
public class TestHttpClient {
    public void testHttpClient() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("123");
        String s = "aaa";
        Map<String, String> map = new HashMap<>();
        map.put("list", String.valueOf(list));
        map.put("aa", s);
        String s1 = JSON.toJSONString(map);
        System.out.println(s1);
        String post = HttpUtil.post("http://localhost:8078/map", s1);
        System.out.println(post);
    }

    public static void main(String[] args) throws IOException {
        TestHttpClient testHttpClient = new TestHttpClient();
        testHttpClient.testHttpClient();
    }
}
