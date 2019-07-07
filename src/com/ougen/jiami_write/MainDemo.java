package com.ougen.jiami_write;

/**
 * @author:ougen
 * @date:2018/9/815:23
 */
public class MainDemo {
    public static void main(String[] args) {
        byte bb[] = Md5Util.get();
        System.out.println(bb.length);
       for (byte b : bb){
           System.out.print(b);
       }
    }
}
