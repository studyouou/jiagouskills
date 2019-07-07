package com.ougen.proxy_write.cglib;

import com.ougen.proxy_write.service.Service;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author:ougen
 * @date:2018/9/512:45
 */
public class CglibProxy implements MethodInterceptor{
    private Object target;
    public Object getProxyByCglib(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("call")){
            methodProxy.invokeSuper(o,objects);
            return  null;
        }
        System.out.println("Cglib处理前");
        methodProxy.invokeSuper(o,objects);
        System.out.println("Cglib处理后");
        return null;
    }
}
