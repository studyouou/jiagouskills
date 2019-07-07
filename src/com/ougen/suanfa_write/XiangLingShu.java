package com.ougen.suanfa_write;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author:ougen
 * @date:2018/12/2810:30
 */
public class XiangLingShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(",");
        int num = Integer.parseInt(s[1]);
        anwser(s[0],num);
    }
    private static void anwser(String str , int num){
        String c = null;
        int max = 0;
        List<Integer> set = new ArrayList<Integer>();
        for (int i = 0;i<26;i++){
            set.clear();
            c = String.valueOf((char)('a'+i));
            int index = 0;
            if (str.contains(c)){
                while (str.lastIndexOf(c)!=(index = str.indexOf(c,index))){
                    set.add(index);
                    index++;

                }
                set.add(index);
                int[] s = new int[set.size()];
                for(int j=0 ;j<set.size();j++){
                    s[j] = set.get(j);
                }
                max = Math.max(max , suanFa(s,0,s.length-1));
            }
        }
        System.out.println(max);
    }
    private static int suanFa(int[] num,int left,int right){
        if (left == right){
            return 0;
        }
        if (left+1==right){
            return  num[right]-num[left];
        }
        return suanFa(num,left+1,right-1)+num[right]-num[left]-(right-left);
    }
}
