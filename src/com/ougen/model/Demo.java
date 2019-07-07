package com.ougen.model;

import java.io.Serializable;

/**
 * @author:ougen
 * @date:2018/8/2312:39
 */
public class Demo implements Serializable{
    private int id ;

    public Demo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
}
