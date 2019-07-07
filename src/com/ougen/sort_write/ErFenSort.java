package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/8/2022:29
 */
//二分排序：思想是从坐标为零开始，后一个数以前面的排好序的以二分法比较插入。
public class ErFenSort {
    public static void main(String[] args) {
        int[] arr = {1,5,12,4,95,54,25,23,433,5,3,56,7,45,78,97,54,32};
        sort2(arr);
        Util.printArr(arr);
    }

    public static void sort2(int[] arr){
        for (int i=0 ;i<arr.length;i++){
            int left = 0;
            int right =i-1;
            int temp = arr[i];
            while (left<=right){
                int mind = (right+left)/2;
                if (temp < arr[mind]){
                    right = mind - 1;
                }else {
                    left = mind + 1;
                }
            }
            for (int j = i - 1 ;j >= left ;j--){
                arr[j+1] = arr[j];

            }
            if (left != i){
                arr[left] = temp ;
            }
        }
    }

    public static void sort(int[] arr){
        if (arr.length<=1) return;
        if (arr[0]>arr[1]) Util.swap(arr,0,1);
        int max,min;
        for (int i = 2 ; i< arr.length ;i++){
           erFen(0,i-1,i,arr);
        }
    }
    private static void erFen(int min , int max ,int curr ,int arr[]){
        if (max - min == 1){
            int temp = arr[curr];
            if (arr[curr]>arr[max]) {
                for (int i = curr ; i>max+1 ;i--){
                    arr[i] = arr[i-1];
                }
                arr[max+1] = temp;
            }else if ((arr[curr]<arr[max]) && (arr[curr]>arr[min])){
                for (int i = curr ; i>max ;i--){
                    arr[i] = arr[i-1];
                }
                arr[max] = temp;
            }else {
                for (int i = curr ; i>max-1 ;i--){
                    arr[i] = arr[i-1];
                }
                arr[max-1] = temp;
            }
           return;
        }
        int miud = (max+min)/2;
        if (arr[curr] >= arr[miud]){
            erFen( miud, max ,curr ,arr);
        }else{
            erFen(min , miud ,curr ,arr);
        }

    }

}
