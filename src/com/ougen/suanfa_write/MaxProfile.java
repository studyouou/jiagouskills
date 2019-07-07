package com.ougen.suanfa_write;

/**
 * @author:ougen
 * @date:2018/12/2410:41
 */
public class MaxProfile {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        int maxProfile = maxProfile(arr);

        byte a = 127;
        byte b = 127;
        a+=b;
        System.out.println(b);
        System.out.println(maxProfile);
    }
    private static int maxProfile(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = 0;
        int n = 1_000_000_007;
        for (int i=0;i<arr.length;i++){
            if (min>arr[i]){
                min = arr[i];
            }else {
                max = Math.max(max,arr[i]-min);
            }
        }
        return max;
    }
}
