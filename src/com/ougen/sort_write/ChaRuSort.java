package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/8/2022:18
 */
public class ChaRuSort {
    public static void main(String[] args) {
        int[] arr = {1,5,12,4,95,54,25,45,74,11,25,4,32,12,2};
        sort2(arr);
        Util.printArr(arr);
    }



    private static int[] sort(int[] arr){
        for (int i = 0; i<arr.length ;i++){
            for (int j = i+1; j< arr.length;j++){
                if (arr[i]>arr[j]){
                   Util.swap(arr , i , j);
                }
            }
        }
        return arr;
    }

    private static int[] sort2(int[] arr){
        for (int i = 0;i<arr.length-1 ; i++){
           int temp = arr[i+1];
           if (temp < arr[i] ){
               int j = i;
               while (j>=0&&arr[j]>temp){
                   arr[j+1]=arr[j];
                   j--;
               }
               arr[j+1] = temp;
           }
        }
        return arr;
    }
}
