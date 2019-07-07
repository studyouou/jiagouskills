package com.ougen.clone_write;

/**
 * @author:ougen
 * @date:2018/9/2015:26
 */
public class MainDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = new int[5];
        for (int i=0;i<5;i++){
            arr[i] = i;
        }
        IsClonedObject isClonedObject = new IsClonedObject(21,"ougen",arr);
        IsClonedObject isClonedObject1 = isClonedObject.clone();
        isClonedObject.setArr(1,9);
        System.out.println(isClonedObject.getName()+"..."+isClonedObject.getI());
        System.out.println(isClonedObject1.getName()+"..."+isClonedObject1.getI());
        isClonedObject.getArr();
        System.out.println();
        isClonedObject1.getArr();
    }
}
