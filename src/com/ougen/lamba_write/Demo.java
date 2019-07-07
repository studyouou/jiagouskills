package com.ougen.lamba_write;

/**
 * @author:ougen
 * @date:2019/3/2813:40
 */
public class Demo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.find((x)-> {
            System.out.println("hello  lamba");
            System.out.println("toto"+x);
        });
    }

    private void find(Lamba lamba){
        int x = 1;
        lamba.find(x);
    }
}

interface Lamba{
     void find(int x);
}
