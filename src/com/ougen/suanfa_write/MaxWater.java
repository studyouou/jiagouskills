package com.ougen.suanfa_write;

/**
 * @author:ougen
 * @date:2018/12/2410:31
 */
public class MaxWater {
    public static void main(String[] args) {
        int max = maxWater(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(max);
    }
    private static int maxWater(int arr[]){
        int i = 0;
        int j = arr.length-1;
        int high = 0;
        boolean flag = false;
        int max = 0;
        while (j>i){
            flag = arr[i]>arr[j];
            high = flag?arr[j] : arr[i];
            max = Math.max(max , (j-i)*high);
            if (flag){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }
}
