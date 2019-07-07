package com.ougen.sort_write;

/**
 * @author:ougen
 * @date:2019/1/516:52
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = ArrInstance.arr;
        quickSort(arr,0,arr.length-1);
        Util.printArr(arr);
    }

    private static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            int ini = left;
            int rr = right;
            int temp = left;
            int one = arr[left];
            while (ini < rr) {
                while (ini < rr && arr[rr] >= one) {
                    rr--;
                }
                if (ini<rr){
                    Util.swap(arr,temp,rr);
                    temp = rr;
                }
                while (ini < rr && arr[ini] <= one) {
                    ini++;
                }
                if (ini<rr){
                    Util.swap(arr,ini,temp);
                    temp = ini;
                }
            }


            quickSort(arr, left, ini - 1);


            quickSort(arr, ini + 1, right);

        }
    }
}
