package com.ougen.threadlocal_read;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author:ougen
 * @date:2018/10/1523:27
 */
public class TheadLocalDemo {
    private static ThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();

    public static void main(String[] args)throws Exception {

        new MyThread().start();
        Thread.sleep(2000);
        System.out.println(threadLocal.get());
    }

     private static class  MyThread extends Thread{
        @Override
         public void run(){
            System.out.println(Thread.currentThread().getName());
            threadLocal.set("Mythread");

        }
     }
}
