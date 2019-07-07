package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/9/713:53
 */
public class MaoPaoSort {
    public static int[] sortArrayByMaoPao(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int j=i;j<arr.length-1;j++){
                if (arr[j]>arr[j+1]){
                    Util.swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }
}
