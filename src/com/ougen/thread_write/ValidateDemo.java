package com.ougen.thread_write;

/**
 * @author:ougen
 * @date:2018/8/2114:52
 */
public class ValidateDemo extends Thread{
    public static   boolean flag = true;

    @Override
    public void run() {
        while (flag){

        }
        System.out.println(flag);
    }

    public static void main(String[] args) {
        two();
    }

    public static void two(){
        ValidateDemo validateDemo = new ValidateDemo();
        validateDemo.start();

        new Thread(){
            @Override
            public void run() {
                flag = false ;
            }
        }.start();

        System.out.println("done");

        System.out.println(flag);
    }

    public static void one(){
        MyThread thread = new MyThread();
        Thread a = new Thread(thread, "t1");
        Thread b = new Thread(thread, "t2");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(thread.num);

    }
}

class MyThread implements Runnable {
    int num = 1000000;
    public void run() {
        if (Thread.currentThread().getName().equals("t1")) {
            increment();
        } else {
            decrement();
        }
    }

    public void increment() {
        for (int i = 0; i < 10000; i++) {
            num++;
        }
    }

    public void decrement() {
        for (int i = 0; i < 10000; i++) {
            num--;
        }
    }
}



