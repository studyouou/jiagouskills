package com.ougen.constructor_write;

/**
 * @author:ougen
 * @date:2018/9/138:49
 */
public class JingTaiThread implements Runnable {
    @Override
    public void run() {
        System.out.println(JingTaiBianLiang.i);
    }
}
