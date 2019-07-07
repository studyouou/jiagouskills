package com.ougen.lock_read;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:ougen
 * @date:2018/8/248:45
 */
public class ReadLock {
    //锁分为4个级别，第一个是无所状态，即通过cas，第二个是偏向锁，如果线程1拥有此锁，此锁不会释放线程，如果当线程2请求获得这个锁，如果线程1还存在，
    // 这个锁会查看自己的线程记录
    //（也就是线程1）是否还需要这个锁，如果需要，此锁就升级为轻量锁。如果这个线程不需要了，则线程2获得锁，并且重置为偏向锁。
    private static Lock lock = new ReentrantLock(false);
    private static Condition condition = lock.newCondition();
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    public void method(){
        lock.lock();
    }

    public static void main(String[] args) {
        for (int i = 0;i<5;i++){
            new Thread(){
                @Override
                public void run() {
                    lock.lock();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally{
                        lock.unlock();
                    }
                }
            }.start();
        }
    }
}
