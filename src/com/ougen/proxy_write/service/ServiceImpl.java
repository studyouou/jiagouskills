package com.ougen.proxy_write.service;

/**
 * @author:ougen
 * @date:2018/9/59:07
 */
public class ServiceImpl implements Service {
    @Override
    public void method() {
        System.out.println("method 方法");
    }

    @Override
    public void call() {
        System.out.println("call 方法");
    }
}
