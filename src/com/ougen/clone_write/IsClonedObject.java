package com.ougen.clone_write;

/**
 * @author:ougen
 * @date:2018/9/2015:21
 */
public class IsClonedObject implements Cloneable{//有些需要更复杂来克隆，比如数组,数组clone的话需要新建一个新的数组,不然的话clone出来的对象是一个数组的引用
                                                    // 。下面实例
    private int i;
    private String name ;
    private int[] arr ;

    public void getArr() {
        for (int i : arr)
        System.out.print(i+",");
    }

    public void setArr(int i,int num) {
        arr[i] = num;
    }

    public IsClonedObject(int i, String name, int arr[]){
        this.i=i;
        this.name = name;
        this.arr = arr;
    }
    @Override
    protected IsClonedObject clone() throws CloneNotSupportedException {
        IsClonedObject isClonedObject =  (IsClonedObject) super.clone();
        int[] arrNew = new int[isClonedObject.arr.length];
        isClonedObject.arr = arrNew;
        for (int i=0;i<arrNew.length;i++){
            arrNew[i] = arr[i];
        }
        return isClonedObject;
//        return (IsClonedObject) super.clone();//直接返回数组的引用相同  所以不能这样
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
