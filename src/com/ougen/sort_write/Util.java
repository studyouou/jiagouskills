package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/8/2022:34
 */
public class Util {
    public static void printArr(int[] arr){
        for (int i : arr){
            System.out.print(i+",");
        }
    }
    public static void swap(int[] arr , int i,int j){
        arr[i] = arr[i] ^ arr[j] ;
        arr[j] = arr[i] ^ arr[j] ;
        arr[i] = arr[i] ^ arr[j] ;
    }
}
