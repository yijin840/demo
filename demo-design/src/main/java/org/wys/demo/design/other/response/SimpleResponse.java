package org.wys.demo.design.other.response;

import cn.hutool.http.HttpUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import okhttp3.*;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author wys
 * @date 2022/6/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SimpleResponse extends BaseResponse {
    private static final long serialVersionUID = -3727680121138319629L;

    public static void main(String[] args) throws IOException {
        System.out.println("123456");
    }

}
