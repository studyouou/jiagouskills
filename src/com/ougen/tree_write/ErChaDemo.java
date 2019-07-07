package com.ougen.tree_write;

import java.util.HashMap;

/**
 * @author:ougen
 * @date:2018/8/1822:42
 */
public class ErChaDemo {

    public static void main(String[] args) {
//        ErChaTree<Integer> erChaTree = new ErChaTree<Integer>();
//        erChaTree.insert(5);
//        erChaTree.insert(10);
//        erChaTree.insert(8);
//        erChaTree.insert(12);
//        erChaTree.insert(3);
//        erChaTree.insert(2);
//        erChaTree.insert(4);
//        erChaTree.toPrin();
        System.out.println(method());

    }
    private static int method(){
        int a = 30;
        try{
            int i = 1/0;
            return  10;
        }catch (Exception e){
            return a;
        }finally {
            a = 40;
            return a;
        }
    }
}
