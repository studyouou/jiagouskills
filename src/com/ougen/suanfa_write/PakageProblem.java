package com.ougen.suanfa_write;

/**
 * @author:ougen
 * @date:2019/1/915:05
 */
public class PakageProblem {
    public static void main(String[] args) {
        int value[] = {13,15,17,20,11,39};
        int weigt[] = {3,4,5,6,2,10};
        System.out.println(maxValue(value,weigt,12));

    }

    private static int maxValue(int[] value, int[] weigt, int c) {
        int[][] wv = new int[weigt.length+1][c+1];
        int[] m = new int[weigt.length];
        for(int i = 1 ;i<=c;i++){
            for (int j = 1;j<=weigt.length;j++) {
                if (weigt[j-1]<=i){
                    wv[j][i] = Math.max(wv[j-1][i-weigt[j-1]]+value[j-1],wv[j-1][i]);
                }else {
                    wv[j][i] = wv[j-1][i];
                }
            }
        }
        printResultOfSelect(wv,weigt,value,c);
        return wv[weigt.length][c];
    }

    private static void printResultOfSelect(int[][] mv,int[] weight,int[] value,int c){
        int[] m = new int[weight.length];
        int j = 5,n=c;
        do {
            if (weight[j]<=n){
                if (mv[j][n] > mv[j][n - weight[j]]+value[j]){
                    m[j] = 0;
                }else {
                    m[j] = 1;
                    n=n-weight[j];
                }
            }else {
                m[j] = 0;
            }
            j--;
        }while (j>=0);
        for (int t : m){
            System.out.print(t+" ");
        }
    }
}
