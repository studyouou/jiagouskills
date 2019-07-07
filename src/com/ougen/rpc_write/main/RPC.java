package com.ougen.rpc_write.main;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @author:ougen
 * @date:2018/10/2316:34
 */
public class RPC {
    public static Object getService(Class clazz)throws Exception{
        return Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Socket socket = new Socket("localhost",1111);
                String className = clazz.getName();
                String methodName = method.getName();
                Class[] parameterTypes = method.getParameterTypes();
                ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
                os.writeUTF(className);
                os.writeUTF(methodName);
                os.writeObject(parameterTypes);
                os.writeObject(args);

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Object o = ois.readObject();

                os.close();
                ois.close();
                socket.close();
                return o;
            }
        });

    }
}
