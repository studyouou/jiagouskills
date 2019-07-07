package com.ougen.map_read;

import java.util.HashMap;

/**
 * @author:ougen
 * @date:2018/8/1811:02
 */
public class MyHashMap {
    private HashMap myHashMap;
    //HashMap 实现原理是数组链接，在HashMap内部有一个Entry接口和Node类，Node类实现了Entry接口并且实现了其方法。
    //HashMap存储数据使用Node数组储存，当put一个key，value时，HashMap首先会去算key其hash值，在根据hash值去找到在
    //Node数组里的索引，如果Node数组当前索引存在有key，则再会去调用key的equals方法去对比数组里存在Node对象的key，
    //当不相同时，则会采用单向链表储存下去。当单向链表过长时（7），则会将单向链表改为双向链表，这样可以快速查询。

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(new Person(1,"1"),"");
        hashMap.put(new Person(2,"1"),"");
        hashMap.put(new Person(3,"1"),"");
        hashMap.put(new Person(4,"1"),"");
        hashMap.put(new Person(5,"1"),"");
        hashMap.put(new Person(6,"1"),"");
        hashMap.put(new Person(7,"1"),"");
        hashMap.put(new Person(8,"1"),"");
        hashMap.put(new Person(9,"1"),"");
        hashMap.put(new Person(10,"1"),"");
        hashMap.put(new Person(11,"1"),"");
        hashMap.put(new Person(12,"1"),"");
        hashMap.put(new Person(13,"1"),"");


    }
}

class Person{
    private int age ;
    private String name ;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person person = (Person)obj;
            if (person.age != this.age)
                return false;
            if (!this.name.equals(person.name))
                return false;
            return true;
        }
        return false;
    }
}
