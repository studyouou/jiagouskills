package com.ougen.constructor_write;

/**
 * @author:ougen
 * @date:2018/9/1111:44
 */
public class Demo extends A {
    public Demo(){
        this(1);
    }
    public Demo(int j){
        super(j);
    }

    public static void main(String[] args) {
        new Demo(1);
    }
}

class A {
    public A(){
        System.out.println("A()");
    }
    public A(int i){
        System.out.println("A("+i+")");
    }
}
