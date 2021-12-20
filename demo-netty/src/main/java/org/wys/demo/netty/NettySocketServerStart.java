package org.wys.demo.netty;

import org.wys.demo.netty.server.NettySocketServer;

/**
 * @author wys
 * @date 2021/11/30
 */
public class NettySocketServerStart {

    public static void main(String[] args) {
        try {
            NettySocketServer.bind(8088);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
