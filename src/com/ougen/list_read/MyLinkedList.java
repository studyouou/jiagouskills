package com.ougen.list_read;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author:ougen
 * @date:2018/8/1810:45
 */
public class MyLinkedList {
    public static void main(String[] args) {

//        TreeSet treeSet = new TreeSet();
//        TreeSet treeSet1 = new TreeSet();
//        System.out.println(treeSet.getClass().getName()+"...."+treeSet1.getClass().getName());
    }

    public static void paramter(){
        Type type[] = B.class.getGenericInterfaces();
        for (Type t : type) {
            System.out.println(t);
            if (ParameterizedType.class.isAssignableFrom(t.getClass())) {
                Type type1 = ((ParameterizedType) t).getRawType();
                System.out.println(type1);
            }
        }
    }
}

interface A<T,B>{}

class B<T,B> implements A<T,B>{

}
