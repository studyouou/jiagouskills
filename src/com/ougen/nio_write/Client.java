package com.ougen.nio_write;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import sun.nio.cs.StreamDecoder;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:ougen
 * @date:2018/10/2122:48
 */
public class Client implements Runnable{
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private SocketChannel socketChannel ;
    private  Selector selector ;

    public void setS(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    private String s = null;
    public Client()throws Exception {
        init();
    }
    private void init()throws Exception{
        socketChannel = SocketChannel.open();
        selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost",8811));
        socketChannel.register(selector,SelectionKey.OP_CONNECT);
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Client client = new Client();
        new Thread(client).start();
//        while (true){
//            try {
//                String temp = null;
//                if ((temp = br.readLine()) != null){
//
//                }
//                if ("over".equals(temp)){
//                    break;
//                }
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
    @Override
    public void run() {
        try {
            sendMessage(this.socketChannel,this.selector,"你好");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ;
    }
    private  void sendMessage(SocketChannel socketChannel, Selector selector, String msg) throws Exception{
        Set<SelectionKey> selectionKeys ;
        while (true){
            if (selector.select() <= 0 ){
                continue;
            }
            selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()){
                SelectionKey selectionKey = it.next();
                if (socketChannel.isConnectionPending()) {
                    if (selectionKey.isConnectable()) {
                        it.remove();
                        while (!socketChannel.finishConnect()){
                            Thread.sleep(3000);
                        }
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        byteBuffer.put(msg.getBytes("utf-8"));
                        byteBuffer.flip();
                        channel.write(byteBuffer);
                    }
                }
                if (selectionKey.isReadable()){
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    byteBuffer.clear();
                    while (channel.read(byteBuffer)>0){
                        System.out.println(new String(byteBuffer.array()));
                        byteBuffer.clear();
                    }
                }
            }
        }


    }

}
