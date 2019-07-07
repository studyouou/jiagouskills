package com.ougen.single_write;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @author:ougen
 * @date:2019/1/619:01
 */
public class LanHan {
    private LanHan(){

    }

    private static volatile LanHan lanHan = null ;
    public static LanHan getInstance(){
        if (lanHan == null){
            synchronized (LanHan.class){
                if (lanHan == null){
                    lanHan = new LanHan();
                }
            }
        }
        return lanHan;
    }
}
