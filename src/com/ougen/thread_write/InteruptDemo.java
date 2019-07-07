package com.ougen.thread_write;

/**
 * @author:ougen
 * @date:2018/8/2112:44
 */
public class InteruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                while (true){
                //    System.out.println("Thred1");
                }
            }
        };
        final Thread thread2 = new Thread(){
            @Override
            public void run() {
                   try {
                       Thread.sleep(3000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   super.run();
               }

        };


        thread1.start();
        thread2.start();

        thread1.interrupt();
        thread2.interrupt();

        System.out.println(thread1.isInterrupted());
        System.out.println(thread2.isInterrupted());
        System.out.println(thread1.isInterrupted());
        System.out.println(thread2.isInterrupted());
    }
}
