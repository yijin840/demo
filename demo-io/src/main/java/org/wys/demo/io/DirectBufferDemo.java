package org.wys.demo.io;

import sun.nio.ch.DirectBuffer;

import java.nio.ByteBuffer;

/**
 * @author wys
 * @date 2022/5/25
 */
public class DirectBufferDemo {

    public static void main(String[] args) {
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
    }

}
