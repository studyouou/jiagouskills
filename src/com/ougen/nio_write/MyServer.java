package com.ougen.nio_write;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;

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
 * @date:2019/6/2415:21
 */
public class MyServer {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private ByteBuffer buffer;
    public MyServer(){
        init();
    }

    private void init() {
        try {
            buffer = ByteBuffer.allocate(1024);
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            ServerSocket socket = serverSocketChannel.socket();
            socket.bind(new InetSocketAddress(8811));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            listener(selector);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listener(Selector selector) throws IOException {
        while (true){
            if (selector.select(3000)==0) {
                continue;
            }
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()){
                SelectionKey sele = keys.next();
                if (sele.isAcceptable()){
                    ServerSocketChannel ssc = (ServerSocketChannel) sele.channel();
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(sele.selector(),SelectionKey.OP_READ );
                }
                if (sele.isReadable()){
                    toRead(sele);
                }
                if (sele.isWritable()){
                    toWrite(sele);
                }
                keys.remove();
            }

        }
    }

    private void toWrite(SelectionKey sele) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) sele.attachment();
        SocketChannel channel = (SocketChannel) sele.channel();
        while (byteBuffer.hasRemaining()){
            channel.write(byteBuffer);
        }
        byteBuffer.compact();
    }

    private void toRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel == null){
            return;
        }
        buffer.clear();
        int len = socketChannel.read(buffer);
        while (len>0){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            System.out.println();
            len = socketChannel.read(buffer);
            buffer.clear();
        }
        socketChannel.write(ByteBuffer.wrap("i has recived".getBytes()));
    }

    public static void main(String[] args) {
        MyServer myServer = new MyServer();
    }
}
