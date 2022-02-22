package org.wys.demo.http.kevinsawicki;


import com.github.kevinsawicki.http.HttpRequest;

import java.io.BufferedInputStream;
import java.io.IOException;

/**
 * @author wys
 * @date 2022/1/13
 */
public class KevinHttpUtil {

    private void streamRead() {
        byte[] bytes = new byte[2048];
        try(BufferedInputStream buffer = HttpRequest.get("https://youtube.com").buffer()) {
            while ((buffer.read(bytes, 0, bytes.length)) != -1) {
                String s = new String(bytes);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getRead() {
        String body = HttpRequest.get("https://twitch.com").body();
        System.out.println(body);
    }
    public static void main(String[] args) {
        KevinHttpUtil kevinHttpUtil = new KevinHttpUtil();
        kevinHttpUtil.getRead();
    }

}
