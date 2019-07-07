package com.ougen.bitset_write;

import com.ougen.set_read.MyTreeSet;

/**
 * @author:ougen
 * @date:2018/8/2012:14
 */
public class MyBitSet {

    public static void main(String[] args) {
        MyBitSet myBitSet = new MyBitSet();
        for (int i = 0 ; i<100 ;i++){
            if (i%2==0){
                myBitSet.set(i);
            }

        }
        for (int i = 0 ; i<100 ;i++){

                if (myBitSet.get(i)){
                    System.out.println(i);
                }


        }

    }

    private int[] words ;

    private final int WEI_YI_NUM = 5;

    public MyBitSet(){
        words = new int[10000000];
    }

    public void set (int num ){
        int wordsindex = getIndex(num);

        words[wordsindex] |= 1 << num ;
    }

    public boolean get(int num){
        int wordindex = getIndex(num);
        return  ((words[wordindex] >> num) & 1) == 1 ;
    }

    private int getIndex(int num){
        return num >> WEI_YI_NUM;
    }
}
