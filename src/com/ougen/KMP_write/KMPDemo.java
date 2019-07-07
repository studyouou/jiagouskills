package com.ougen.KMP_write;

/**
 * @author:ougen
 * @date:2018/8/2015:21
 */
public class KMPDemo {
    public static boolean findInString(String target , String all){
        boolean flag = true;
        int count ;
        char[] t = target.toCharArray();
        char[] a = all.toCharArray();
        for (int i = 0 ;i<all.length();i++){
            count = 0 ;
            for (int j = 0 ,x=i; j<target.length();j++,i++){
                if (t[j] != a[i]){
                    flag = false ;
                    break;
                }
                count ++ ;
            }
            if (count == target.length()){
                flag = true ;
                break;
            }

        }

        return flag;
    }



    public static boolean findByKMP(String target , String all){
        boolean flag = false ;       //a b s s s s s s s s d
        char[] t = target.toCharArray(); // s s s s s b
        char[] a = all.toCharArray();
        for (int i = 0;i<all.length();i++){
            for (int j = 0;j<target.length();j++){

            }
        }
        return false;
    }
}
