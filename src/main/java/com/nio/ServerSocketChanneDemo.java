package com.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChanneDemo {
    public static void main(String[] args) throws Exception {
//        打开ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(9999));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
//do something with socketChannel...
            if (socketChannel == null) {
                break;
            }

        }
//        关闭ServerSocketChannel
        serverSocketChannel.close();
    }
}
