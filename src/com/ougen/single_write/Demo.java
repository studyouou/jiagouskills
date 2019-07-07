package com.ougen.single_write;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * @author:ougen
 * @date:2019/1/618:44
 */
public class Demo {
    public static void main(String[] args)throws Exception {

//        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("e:/erhan.obj"));
//        o.writeObject(e);
        ObjectInputStream i = new ObjectInputStream(new FileInputStream("e:/erhan.obj"));
        ErHan e1 = (ErHan) i.readObject();
        ErHan e = ErHan.getInstance();
        System.out.println(e);
        System.out.println(e1);
        EumnSingle eee = EumnSingle.INSTANCE;
        eee.get();
    }
}
