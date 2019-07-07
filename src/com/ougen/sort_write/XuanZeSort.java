package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2018/9/712:52
 */
public class XuanZeSort {
    public static int[] sortByXuanZe(int[] arr){
        if (arr.length==0){
            System.out.println("数组为零");
            return null;
        }

        for (int i=0;i<arr.length;i++){
            int min = arr[i];
            int k = i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[j]<min){
                    min = arr[j];
                    k=j;
                }
            }
            if (i!=k)
                Util.swap(arr,i,k);
        }
        return arr;
    }

}
