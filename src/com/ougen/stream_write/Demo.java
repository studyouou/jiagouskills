package com.ougen.stream_write;

import java.util.stream.Stream;

/**
 * @author:ougen
 * @date:2019/6/2022:47
 */
public class Demo {
    public static void main(String[] args) {
        me("ll",new Lamm()::say);
    }
    public static void me(String s,ll l){
        l.method(s);
    }
}
interface ll{
    void method(String s);
}
class Lamm{
    public void say(Object o){
        if (o instanceof Demo1.B){
            Demo1.B s = (Demo1.B)o;
            System.out.println(s.getAge());
            return;
        }
        System.out.println(o);
    }
}
