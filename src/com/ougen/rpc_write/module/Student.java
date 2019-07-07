package com.ougen.rpc_write.module;

import java.io.Serializable;

/**
 * @author:ougen
 * @date:2018/10/2316:30
 */
public class Student implements Serializable{
    private int id;

    private String name;

    private int age;

    private String shcool ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getShcool() {
        return shcool;
    }

    public void setShcool(String shcool) {
        this.shcool = shcool;
    }
}
