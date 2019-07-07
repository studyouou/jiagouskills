package com.ougen.suanfa_write;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author:ougen
 * @date:2018/12/2315:09
 */
public class Sum1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] s = getNum2(arr,18);
        printArr(s);
    }
    private static void printArr(int arr[]){
        if (arr==null){
            System.out.print("没有");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    private static int[] getNum(int[] arr,int tar){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for (int i=0;i<arr.length;i++){
            int cha = tar - arr[i];
            if (map.containsKey(cha)&&i!=map.get(cha)){
                return new int[]{arr[i],cha};
            }
        }
        return null;
    }

    private static int[] getNum2(int[] arr,int tar){
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<arr.length;i++){
            int cha = tar - arr[i];
            if (map.containsKey(cha)&&map.get(cha)!=i){
                return new int[]{arr[i],cha};
            }
            map.put(arr[i],i);
        }
        return null;
    }
}
