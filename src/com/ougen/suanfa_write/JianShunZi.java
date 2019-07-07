package com.ougen.suanfa_write;

/**
 * @author:ougen
 * @date:2019/1/619:51
 */
public class JianShunZi {
    public static void main(String[] args) {
        System.out.println(maxProfile(10
        ));
    }

    private static int maxProfile(int n ){
        if (n==1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n==3){
            return 3;
        }
        if (n==4){
            return 4;
        }
        return 3*maxProfile(n-3);

    }
}
