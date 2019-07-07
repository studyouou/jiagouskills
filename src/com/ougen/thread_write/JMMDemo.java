package com.ougen.thread_write;

/**
 * @author:ougen
 * @date:2018/8/2116:38
 */
public class JMMDemo {
    int i = 0;
    public synchronized void read(){
        System.out.println(i);
    }
    public synchronized void write(){
        i++;

    }

    public static void main(String[] args) {
        JMMDemo jmmDemo = new JMMDemo();

        new Thread(){
            @Override
            public void run() {
                jmmDemo.write();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                jmmDemo.read();
            }
        }.start();
    }
}
