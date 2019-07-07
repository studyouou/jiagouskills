package com.ougen.proxy_write.main;

import com.ougen.proxy_write.cglib.CglibProxy;
import com.ougen.proxy_write.service.Service;
import com.ougen.proxy_write.service.ServiceImpl;

/**
 * @author:ougen
 * @date:2018/9/512:53
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Service service = (Service) cglibProxy.getProxyByCglib(new ServiceImpl());
        service.method();
    }
}
