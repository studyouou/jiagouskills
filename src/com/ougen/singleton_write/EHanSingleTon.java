package com.ougen.singleton_write;

/**
 * @author:ougen
 * @date:2018/9/139:06
 */
public class EHanSingleTon {
    private static EHanSingleTon instance = new EHanSingleTon();
    private EHanSingleTon(){
        System.out.println("实例化了");
    }
    public static EHanSingleTon getSingleton(){
        return instance;
    }
    public void method(){
        System.out.println("调用了method方法");
    }
}
