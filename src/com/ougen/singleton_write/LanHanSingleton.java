package com.ougen.singleton_write;

/**
 * @author:ougen
 * @date:2018/9/139:10
 */
public class LanHanSingleton {
    private LanHanSingleton(){
        System.out.println("实例化了");
    }

    public static LanHanSingleton SINGLETON = null;
    public void method(){
        System.out.println("调用了method方法");
    }
    public static LanHanSingleton getSingleton(){
        if (SINGLETON == null){
            synchronized (LanHanSingleton.class){
                if (SINGLETON == null){
                    SINGLETON = new LanHanSingleton();
                }
            }
        }
        return SINGLETON;
    }
}
