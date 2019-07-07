package com.ougen.proxy_write.main;

import com.ougen.proxy_write.dynatic.JDKProxy;
import com.ougen.proxy_write.service.Service;
import com.ougen.proxy_write.service.ServiceImpl;

/**
 * @author:ougen
 * @date:2018/9/59:17
 */
public class DynaticProxy {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        JDKProxy jdkProxy = new JDKProxy();
        Service service1 = (Service) jdkProxy.getTarget(service);
        service1.call();
    }
}
