package com.ougen.singleton_write;

/**
 * @author:ougen
 * @date:2018/9/139:03
 */
public class JingtaiLei {
    private JingtaiLei(){
        System.out.println("实例化了");
    }
    public static final JingtaiLei SINGLETON = new JingtaiLei();
    public void method(){
        System.out.println("调用了method方法");
    }
}
