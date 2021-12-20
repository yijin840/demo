package org.wys.demo.netty;

import org.wys.demo.netty.client.NettySocketClient;

/**
 * @author wys
 * @date 2021/11/30
 */
public class NettySocketClientStart {

    public static void main(String[] args) {
        try {
            NettySocketClient.connect("localhost", 8088);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
