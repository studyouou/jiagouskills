package com.ougen.single_write;

import java.io.Serializable;

/**
 * @author:ougen
 * @date:2019/1/618:39
 */
public class ErHan implements Serializable {
    private ErHan(){
        System.out.println("ini");
    }
    private static ErHan e = new ErHan();
    public static ErHan getInstance(){
        return e;
    }

//    private Object readResolve(){
//        return e;
//    }
}
