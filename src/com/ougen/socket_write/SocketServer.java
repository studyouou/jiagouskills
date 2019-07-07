package com.ougen.socket_write;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:ougen
 * @date:2019/6/2410:20
 */
public class SocketServer {
    private static ServerSocket serverSocket ;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8811);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(b))!=-1){
            System.out.println(new String(b));
        }
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
