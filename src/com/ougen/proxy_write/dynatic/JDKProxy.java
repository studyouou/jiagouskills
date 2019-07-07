package com.ougen.proxy_write.dynatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:ougen
 * @date:2018/9/59:05
 */
public class JDKProxy implements InvocationHandler{
    private Object target;
    public Object getTarget(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理前");
        Object o =  method.invoke(target,args);
        System.out.println("动态代理后");
        return o;
    }
}
