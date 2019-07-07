package com.ougen.unsafe_write;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:ougen
 * @date:2018/9/188:53
 */
public class UnsafeDemo {
    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        User user = (User) unsafe.allocateInstance(User.class);
        Class clazz = user.getClass();
        Field age = clazz.getDeclaredField("age");
        Field name = clazz.getDeclaredField("name");
        Field atomicInteger = clazz.getDeclaredField("atomicInteger");
        Field id = clazz.getDeclaredField("id");
        System.out.println(user);
        unsafe.putInt(user,unsafe.objectFieldOffset(age),21);
        unsafe.putObject(user,unsafe.objectFieldOffset(name),"欧根");
        unsafe.putObject(user,unsafe.objectFieldOffset(atomicInteger),new AtomicInteger());
        System.out.println(user);
        Object userClazz =  unsafe.staticFieldBase(id);
        long idoffset = unsafe.staticFieldOffset(id);
        unsafe.putObject(userClazz,idoffset,"two");
        System.out.println(user);
        System.out.println(user.count());


        long address = unsafe.allocateMemory(1);
        unsafe.putAddress(address,Long.valueOf("111"));
        long data = unsafe.getAddress(address);
        System.out.println(String.valueOf(data)+"...size="+unsafe.addressSize());
    }
}
class User{
    private int age ;
    private String name;
    private static String  id = "one";
    private AtomicInteger  atomicInteger  ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int count(){
        return atomicInteger.get();
    }
    public User() {
        atomicInteger.incrementAndGet();
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", atomicInteger=" + atomicInteger +
                ", id=" + id +
                '}';
    }
}
