package com.ougen.constructor_write;

/**
 * @author:ougen
 * @date:2018/9/138:48
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println(JingTaiBianLiang.i);
        JingTaiBianLiang.i=10;
        System.out.println(JingTaiBianLiang.i);
        new Thread(new JingTaiThread()).start();
    }
}
