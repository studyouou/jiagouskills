package com.ougen.rpc_write.main;

import com.ougen.rpc_write.api.StudentDao;
import com.ougen.rpc_write.service.StudentService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:ougen
 * @date:2018/10/2317:27
 */
public class Server {
    public static void main(String[] args)throws Exception {
        ServerSocket serverSocket = new ServerSocket(1111);
        while (true){
            Socket socket = serverSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Class c = null;
            String className = ois.readUTF();
            String methodName = ois.readUTF();
            Class[] classes = (Class[]) ois.readObject();
            Object[] ars = (Object[]) ois.readObject();
            if (className.equals(StudentDao.class.getName())){
                c = StudentService.class;
            }
            if (c == null){
                throw new RuntimeException("没有找到该类");
            }
            Method method = c.getMethod(methodName,classes);
            Object o = method.invoke(c.newInstance(),ars);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(o);
            oos.close();
            ois.close();
            socket.close();
        }
    }
}
