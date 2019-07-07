package com.ougen.thread_write;

import java.util.concurrent.*;

/**
 * @author:ougen
 * @date:2018/8/2111:21
 */
public class CallableDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        future();
    }

    public static void future() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("执行了");
                return "123";
            }
        }){
            @Override
            protected void done() {
                try {
                    System.out.println("future.done():" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }
    public static void callAble() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "121";
            }
        });
        System.out.println(f.get());
        executorService.shutdown();
    }
}
