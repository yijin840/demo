package org.wys.demo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author wys
 * @date 2022/1/14
 */
public class OutputStreamTest {

    public static void main(String[] args) throws IOException {
        String string = "123123abcabc";
        OutputStream outputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        outputStream.write(bytes);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        byte[] read = new byte[1024];
        int cnt;
        while ((cnt = bis.read(read)) != -1) {
            System.out.println((char) cnt);
        }
    }

}
