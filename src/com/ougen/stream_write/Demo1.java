package com.ougen.stream_write;

import java.util.stream.Stream;

/**
 * @author:ougen
 * @date:2019/6/2023:01
 */
public class Demo1 {
    public static void main(String[] args) {
        Stream<B> stream = Stream.of(new B(1),new B(2),new B(3),new B(4));
        stream = stream.sorted((B a,B b)->{
           return b.getAge()-a.getAge();
        }).limit(2);
        stream.forEach(new Lamm()::say);
    }
    static class B{
        public B(int age){
            this.age = age;
        }
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
