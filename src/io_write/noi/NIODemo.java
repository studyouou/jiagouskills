package io_write.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:ougen
 * @date:2018/9/109:13
 */
public class NIODemo {
    private static final int PORT = 12345;
    private int id  = 100;
    public static void main(String[] args)throws Exception {
        ServerSocketChannel channel = ServerSocketChannel.open();
        ServerSocket serverSocket = channel.socket();
        Selector selector = Selector.open();
        serverSocket.bind(new InetSocketAddress("localhost",PORT));
        channel.configureBlocking(false);
        channel.register(selector,SelectionKey.OP_ACCEPT);
        new NIODemo().listen(selector);
    }
    private void listen(Selector selector) throws Exception {
        System.out.println("启动成功");
        int n ;
        while (true){
             n = selector.select();
            if (n==0) continue;
            Set<SelectionKey> setKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = setKeys.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = it.next();
                if (selectionKey.isAcceptable()){
                    System.out.println("已连接...........");
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel channel = serverSocketChannel.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()){
                    it.remove();
                    System.out.println("准备读就绪");
                    printDate(selectionKey);

                }
            }
        }
    }
    private ByteBuffer buffer = ByteBuffer.allocate(1024);

    private void writeToClient(SelectionKey selectionKey)throws Exception{
        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = channel.accept();
        buffer.clear();
        buffer.put("hello javanio".getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();
    }
    private void printDate(SelectionKey selectionKey) throws Exception {
        int count;
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        buffer.clear();
        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();
            System.out.println(new String(buffer.array()));
            buffer.clear();
        }
        if (count <= 0) {
            channel.close();
        }
    }


}
