package com.ougen.socket_write;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:ougen
 * @date:2019/6/2411:29
 */
public class MySocket {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8811);
        OutputStream o = socket.getOutputStream();
        byte[] b = "this is socket".getBytes();
        o.write(b);
        o.close();
        socket.close();
    }
}
