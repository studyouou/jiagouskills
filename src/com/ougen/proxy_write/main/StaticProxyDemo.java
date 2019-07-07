package com.ougen.proxy_write.main;

import com.ougen.proxy_write.service.Service;
import com.ougen.proxy_write.service.ServiceImpl;
import com.ougen.proxy_write.statics.StaticProxy;

/**
 * @author:ougen
 * @date:2018/9/59:10
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        Service service = new StaticProxy(new ServiceImpl());
        service.call();
    }
}
