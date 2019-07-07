package com.ougen.bitset_read;

import java.util.BitSet;
import java.util.Random;

/**
 * @author:ougen
 * @date:2018/8/1918:16
 */
public class BitSetDemo {
    //BitSet实现原理是，内部储存是一个long数组 ， 一个long是占了64位的，所以一个long型可以储存64个数（如1-64），
    //在set方法中，首先是根据储存值num的大小来确定下标（简单就是 num/64 就是这个num的下标），确定下标后，会储存值，其原理是
    //根据余数大小来确定数所在位置，如1会存在00......010;如果既有1，又有2的话，就会从储存为000.........0110;
    //get方法就是首先将传入的值num获得下标，同set一样，在获得下标后，就会取值（words【下标】），再根据 （数组值 >> 值num）&1 来确定
    //是否存在改数。
    private Runtime runtime;
    public BitSetDemo(){
        runtime = Runtime.getRuntime();
    }
    public static void main(String[] args) {
        System.out.println(1L << 65);
        BitSetDemo bitSetDemo = new BitSetDemo();
        printM(bitSetDemo.runtime);
        int x = 0;
        Random random = new Random();
        BitSet bitSet = new BitSet( );
        for (int i = 0 ; i<1000000;i++){
            if (i%2==0) {
                bitSet.set(i);
            }
        }
        System.out.println(bitSet.size());
        for (int i = 0 ; i<1000000;i++){
            boolean b = bitSet.get(i);
            if (!b)System.out.println(i);
        }
        printM(bitSetDemo.runtime);
    }
    public static void printM(Runtime runtime){
        long maxM = runtime.maxMemory()/(1024*1024);
        long free = runtime.freeMemory()/(1024*1024);
        long x = runtime.totalMemory()/(1024*1024);
        long ues = maxM - x + free ;
        System.out.println(maxM+"..."+free+"..."+x+"..."+ues);
    }
}
