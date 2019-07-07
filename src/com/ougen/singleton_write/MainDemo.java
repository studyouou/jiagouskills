package com.ougen.singleton_write;

/**
 * @author:ougen
 * @date:2018/9/139:05
 */
public class MainDemo {
    public static void main(String[] args) {
        System.out.println("------------------------------");
        JingtaiLei jingtaiLei = JingtaiLei.SINGLETON;
        JingtaiLei jingtaiLei1 = JingtaiLei.SINGLETON;
        System.out.println("------------------------------");
        EHanSingleTon er = EHanSingleTon.getSingleton();
        EHanSingleTon EHanSingleTon1 = EHanSingleTon.getSingleton();
        System.out.println("------------------------------");
        LanHanSingleton lanHanSingleton = LanHanSingleton.getSingleton();
        LanHanSingleton lanHanSingleton1 = LanHanSingleton.getSingleton();
        System.out.println("------------------------------");
        EnumSingleTon enumSingleTon = EnumSingleTon.INSTANCE;
        EnumSingleTon enumSingleTon1 = EnumSingleTon.INSTANCE;
        enumSingleTon.mehtod();
        System.out.println("------------------------------");

    }
}
