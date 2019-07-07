package com.ougen.new_method_java;

import java.util.Arrays;
import java.util.List;

/**
 * @author:ougen
 * @date:2018/10/2514:12
 */
public class Demo {
    public static void main(String[] args) {
        String ss[] = {"123","sdfs","sdfs"};
        List<String> printer = Arrays.asList(ss);

        printer.forEach((play) -> System.out.println(play+";"));

        new Thread(()->System.out.println("ougen")).start();

        int  id = 0;
        new Dao(){

            @Override
            public void print() {
                System.out.println(id);
            }
        }.print();
        Dao dao = ()-> System.out.println("ougen");
        dao.print();
    }
    private static void pr(String s,int integer){
        System.out.println(s+integer);
    }
}
