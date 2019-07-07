package com.ougen.thread_write;

import java.util.concurrent.*;

/**
 * @author:ougen
 * @date:2018/8/2617:50
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,10, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
    }
}
