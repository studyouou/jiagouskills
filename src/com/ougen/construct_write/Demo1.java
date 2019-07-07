package com.ougen.construct_write;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author:ougen
 * @date:2019/1/617:30
 */
public class Demo1 {
    public static void main(String[] args)throws Exception {
        Constructor c = Demo.class.getConstructor(int.class,int.class);
        Demo demo = (Demo)c.newInstance(1,2);
        Class clazz = demo.getClass();
        Method method = clazz.getMethod("method",String.class);
        Object o = method.invoke(demo,"ougen");//object是返回值  如果是没有返回值，
        System.out.println(o);
    }
}
