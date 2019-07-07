package com.ougen.cache_write.ehcache;

import com.ougen.model.Demo;

/**
 * @author:ougen
 * @date:2018/8/2312:48
 */
public class EhCacheMain {
    public static void main(String[] args) {
        EhCacheDemo<Demo> ehCacheDemo = new EhCacheDemo<Demo>(Demo.class);
        ehCacheDemo.cache("1",new Demo(1));
        ehCacheDemo.cache("2",new Demo(1));
        ehCacheDemo.cache("3",new Demo(1));
        ehCacheDemo.cache("4",new Demo(1));
        ehCacheDemo.cache("5",new Demo(1));
        ehCacheDemo.cache("6",new Demo(1));
        ehCacheDemo.cache("7",new Demo(1));
        ehCacheDemo.cache("8",new Demo(1));
        ehCacheDemo.cache("9",new Demo(1));
        ehCacheDemo.cache("10",new Demo(1));

        System.out.println(ehCacheDemo.get("5"));
    }
}
