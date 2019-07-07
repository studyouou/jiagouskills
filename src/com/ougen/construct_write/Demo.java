package com.ougen.construct_write;

/**
 * @author:ougen
 * @date:2019/1/617:31
 */
public class Demo {
    private static int a = 10;
    private int b = 11;
    public String c = "asdf";
    private Demo(String a,int b){
        System.out.println(a);
        System.out.println(b);
        System.out.println("private Demo");
    }

    public Demo(int a,int b){
        System.out.println(a);
        System.out.println(b);
        System.out.println("public Demo");
    }

    public void method(String a){
        System.out.println(a);
    }
}
