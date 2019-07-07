package io_write.noi;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:ougen
 * @date:2018/9/1014:06
 */
public class Client implements Runnable{
    private int id;
    private static int block = 4560;
    private static ByteBuffer byteBuffer = ByteBuffer.allocate(block);
    private static InetSocketAddress address = new InetSocketAddress("localhost",12345);
    public Client(int  id){
        this.id = id;
    }
    public static void main(String[] args)throws Exception {
        for (int i=0 ; i<3 ; i++){
            new Thread(new Client(i)).start();
        }
    }
    @Override
    public void run() {
        SocketChannel channel = null;
        Selector selector = null;
        try {
            channel = SocketChannel.open();
            selector= Selector.open();
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_CONNECT);
            channel.connect(address);
            while (true){
                selector.select();
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    if (key.isConnectable()){
                        if (channel.isConnectionPending()){
                            if (channel.finishConnect()){
                                key.interestOps(SelectionKey.OP_READ);
                                channel.write(ByteBuffer.wrap(("hello java nio"+id).getBytes()));
                            }
                        }
                    }else if (key.isReadable()){

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
