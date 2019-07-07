package com.ougen.proxy_write.statics;

import com.ougen.proxy_write.service.Service;

/**
 * @author:ougen
 * @date:2018/9/59:05
 */
public class StaticProxy implements Service {
    private Service service;
    public StaticProxy(Service service){
        this.service=service;
    }
    @Override
    public void method() {
        System.out.println("静态代理前");
        service.method();
        System.out.println("静态代理后");
    }

    @Override
    public void call() {
        System.out.println("静态代理前");
        service.call();
        System.out.println("静态代理后");
    }
}
