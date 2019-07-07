package com.ougen.nio_write;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author:ougen
 * @date:2019/6/2421:43
 */
public class MySocket implements Runnable{
    private SocketChannel socketChannel;
    private SocketAddress socketAddress;
    public MySocket(){

    }

    private void init() {
        socketAddress = new InetSocketAddress("127.0.0.1",8811);
        try {
            int i = 0;
            socketChannel = SocketChannel.open();
            socketChannel.connect(socketAddress);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while(i<10){
                String s = "i am mysocket "+i;
                byteBuffer.put(s.getBytes());
                byteBuffer.flip();
                while(byteBuffer.hasRemaining()){
                    socketChannel.write(byteBuffer);
                }
                i++;
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MySocket mySocket = new MySocket();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,120, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        threadPoolExecutor.execute(mySocket);
    }

    @Override
    public void run() {
        init();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while(true){
            try {
                int len = socketChannel.read(byteBuffer);
                while (len >0){
                    byteBuffer.flip();
                    while (byteBuffer.hasRemaining()){
                        System.out.print((char)byteBuffer.get());
                    }
                    byteBuffer.clear();
                    len = socketChannel.read(byteBuffer);
                }
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
