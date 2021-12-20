package org.wys.demo.netty.handler;

import com.alibaba.druid.support.http.util.IPAddress;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.InetSocketAddress;

/**
 * @author wys
 * @date 2021/11/30
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        InetSocketAddress address = (InetSocketAddress) ctx.channel().remoteAddress();
        System.out.println("客户端: " + address.getHostName() + " 建立连接");
        ByteBuf result = (ByteBuf) msg;
        byte[] bytesMsg = new byte[result.readableBytes()];
        result.readBytes(bytesMsg);
        String resultStr = new String(bytesMsg);
        System.out.println("Client said:" + resultStr);
        result.release();
        String response = "hello client";
        ByteBuf encoded = ctx.alloc().buffer(4 * response.length());
        encoded.writeBytes(response.getBytes());
        ctx.write(encoded);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


}
