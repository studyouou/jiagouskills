package com.ougen.suanfa_write;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author:ougen
 * @date:2018/12/248:46
 */
public class DeffirentString {
    public static void main(String[] args) {
        int leng = differentString2("lakglkdnlzjaouoajotiejndmn,sdfghauranm,nxoahdgklalskdjgahg");
        System.out.print(leng);
    }
    private static int differentString1(String s){
        char[] schar = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int max = 0 ;
        int left = 0;
        String maxString = "";
        for (int i=0 ; i<schar.length ; i++){
            if (map.containsKey(schar[i])){
                left = Math.max(left,map.get(schar[i])+1);
            }
            map.put(schar[i],i);
            max = Math.max(max,i-left+1);
            maxString = maxString.length()> i-left+1 ? maxString : new String(s.substring(left,i+1));
        }
        System.out.println(maxString+maxString.length());
        return max;
    }

    private static int differentString2(String s){
        char[] schar = s.toCharArray();
        int left = 0 ;
        int max = 0;
        String maxString = "";
        HashSet<Character> set = new HashSet<Character>();
        for (int i=0 ; i<schar.length ; i++){
            while (set.contains(schar[i])){
                set.remove(schar[left]);
                left++;
            }
            set.add(schar[i]);
            max = Math.max(max,i-left+1);
            maxString = maxString.length() > i-left+1 ? maxString : new String(s.substring(left,i+1));
        }
        System.out.println(maxString);
        return max;
    }
}
