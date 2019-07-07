package com.ougen.bloom_write;

import java.util.BitSet;

/**
 * @author:ougen
 * @date:2018/8/2013:17
 */
public class BloomDemo {
    //Bloom Filter 是基于BitSet 的，在Blloom Filter中，有多个hash算法算出其hash值，再将这多个hash值存到bitset中，在查重的时候，只需要算出url的多个hash
    //值，然后在进行对比，只要有一个hash值为不存在bitset中，就可以确定该url不重复，如果hash值都存在的话，基本可以确定url重复了（不是100%）

    private BitSet urlBitSet ;

    private int[] caps ;

    public BloomDemo(){
        urlBitSet = new BitSet();
        caps = new int[]{11,13,29,59};
    }
    public boolean isRepeatUtl(String url){
        boolean flag = true;
        int[] hash = getHashCode(url);
        for (int i = 0 ;i<hash.length ; i++){
           flag = flag && urlBitSet.get(hash[0]);
        }
        if (!flag){
            for (int i = 0; i<hash.length ;i++){
                urlBitSet.set(hash[i]);
            }
        }else {
            System.out.println(url+"重复了");
        }
        return flag;
    }

    private int[] getHashCode(String url) {
        return getHashCode(url,caps);
    }

    private int[] getHashCode(String url , int[] cap) {
        int[] hash = new int[4];
        for (int i = 0; i<cap.length;i++){
            int h = getHashCodeByCap(url,cap[i]);
            hash[i] = h;
        }
        return hash;
    }

    public int getHashCodeByCap(String url , int cap) {
        return url.hashCode()+cap*cap;
    }
}
