package com.ougen.my_linkedlist;

/**
 * @author:ougen
 * @date:2018/10/1711:30
 */
public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<String>();
        linkedList.add("ougen");
        linkedList.add("123");
        linkedList.add("oo");
        linkedList.add("oxox");
        linkedList.add("xxx");
        linkedList.add("qqq");
        linkedList.add("sss");
        System.out.println(linkedList.remove("oo"));
        System.out.println(linkedList.get(5));
    }
}
