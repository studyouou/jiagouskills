package com.ougen.classjiazai_write;

import java.sql.DriverManager;

/**
 * @author:ougen
 * @date:2019/1/513:19
 */
public class DemoMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        LeiJiaZai leiJiaZai = new LeiJiaZai();
        Class c = leiJiaZai.loadClass("DeleteAnswer");
        System.out.println(leiJiaZai.getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
    }
}
