package com.ougen.nio_write;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @author:ougen
 * @date:2018/10/1920:52
 */
public class BufferDemo {
    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        RandomAccessFile raf = new RandomAccessFile("D:\\1copy.txt","rw");
        FileChannel channel = raf.getChannel();
       // read(channel,buffer);
//        int i = channel.read(buffer);
//        if (i > -1){
//            buffer.flip();
//            while (buffer.hasRemaining()){
//                System.out.println(buffer.get());
//            }
//            buffer.clear();
//        }
//        raf.close();;
    }
    private static void read(FileChannel channel,ByteBuffer buffer) throws IOException {

        int i = channel.read(buffer);
        if (i > -1) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            byteBuffer.flip();
            byte[] byt = new byte[1024];
            int j = 0;
            while (byteBuffer.hasRemaining()) {
                byt[j++] = byteBuffer.get();
            }

            System.out.println(new String(byt));
            byteBuffer.clear();
        }
        channel.close();
    }
}
