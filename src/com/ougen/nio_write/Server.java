package com.ougen.nio_write;

import org.apache.ibatis.annotations.SelectKey;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:ougen
 * @date:2018/10/2121:53
 */
public class Server implements Runnable{
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private ServerSocketChannel channel ;
    private ServerSocket socket ;
    private Selector selector ;
    public Server(){
        init();
    }

    private void init() {
        try {
            channel = ServerSocketChannel.open();
            socket = channel.socket();
            selector = Selector.open();
            socket.bind(new InetSocketAddress("localhost",11111));
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            listener(selector);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws  Exception{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute( new Server());
    }

    private  void listener(Selector selector)throws Exception {
        int n = 0;
        while (true){
            n = selector.select();
            if (n <= 0){
                continue;
            }
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> it = keySet.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = it.next();
                selectionKey.interestOps();
                if (selectionKey.isAcceptable()){
                    it.remove();
                    System.out.println("已连接");
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (socketChannel == null){
                        Thread.sleep(3000);
                    }
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                if (selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    byteBuffer.clear();
                    while (socketChannel.read(byteBuffer)>0){
                        System.out.println(new String(byteBuffer.array()));
                        byteBuffer.clear();
                    }
                    selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_READ);
                }
                if (selectionKey.isWritable()){
                    sendMsg(selectionKey);
                }
            }
        }
    }

    private static void sendMsg(SelectionKey selectionKey) {
       byteBuffer.clear();
       SocketChannel channel = (SocketChannel) selectionKey.channel();
       if (selectionKey.isWritable()){
           try {
               channel.write(byteBuffer.put("消息接受成功".getBytes("utf-8")));
               selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_READ);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }


}
