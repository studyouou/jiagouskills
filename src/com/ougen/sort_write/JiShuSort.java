package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/9/714:02
 */
public class JiShuSort {
    public static int[] sortByJiShu(int[] arr){
        int arrTong[] = new int[100];
        for (int i : arr){
            arrTong[i]++;
        }
        int[] newArr = new int[arr.length];
        int k = 0;
        for (int i = 0 ; i< arrTong.length;i++){
            for (int j=0;j<arrTong[i];j++){
                newArr[k] = i;
                k++;
            }
        }
        return newArr;
    }
}
