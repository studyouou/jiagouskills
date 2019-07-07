package com.ougen.sort_write;

import java.util.Arrays;

/**
 * @author:ougen
 * @date:2019/1/516:14
 */
public class ShellSort {
    public static void main(String[] args) {
        int arr[] = ArrInstance.arr;
        Util.printArr(shellSort(arr));
    }

    private static int[] shellSort(int[] arr){
        int len = arr.length;
        int group = len ;
        while ((group = group/2)!=0){
            for (int i = 0 ; i < group ; i++){
                for (int n = i ; n < len - group ; n = n + group){
                    int temp = arr[n+group];
                    int j = n ;
                    while (j>=0 && temp < arr[j]){
                        arr[j+group] = arr[j];
                        j = j - group;
                    }
                    arr[j+group] = temp;
                }
            }
        }
        return  arr;
    }
}
