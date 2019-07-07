package com.ougen.singleton_write;

/**
 * @author:ougen
 * @date:2018/9/139:16
 */
public enum  EnumSingleTon {
   INSTANCE;
   private EnumSingleTon(){
       System.out.println("实例化了");
   }
   public void mehtod(){
        System.out.println("调用method方法");
   }
}
