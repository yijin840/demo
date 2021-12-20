package org.wys.demo.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author wys
 * @date 2021/11/30
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("NettyClientHandler通道建立");
        ByteBuf result = (ByteBuf)msg;
        byte[] results = new byte[result.readableBytes()];
        result.readBytes(results);
        System.out.println("Server said:" + new String(results));
        result.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        while(true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ByteBuf byteBuf = ctx.alloc().buffer(4 * br.readLine().length());
            byteBuf.writeBytes(br.readLine().getBytes(StandardCharsets.UTF_8));
            ctx.writeAndFlush(byteBuf);
            System.out.println();
        }
//        br.close();
    }

}
