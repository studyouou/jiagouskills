package com.ougen.update.date;

/**
 * @author:ougen
 * @date:2018/8/209:00
 */
public class Update {
    public static final int _1MB = 1024 * 1024;
    //每个byte记录8bit信息,也就是8个数是否存在于数组中
    public static byte[] flags = new byte[ 512 * _1MB ];


    public static void main(String[] args) {
        //待判重数据
        int[] array = {255, 1,2,3,2, 0, 65536, 255,65536};
        System.out.println(1 << 32);
        int index = 0;
        for(int num : array) {
            if(!getFlags(num)) {
                //未出现的元素
                array[index] = num;
                index = index + 1;
                //设置标志位
                setFlags(num);
                System.out.println("set " + num);
            } else {
                System.out.println(num + " already exist");
            }
        }
    }

    public static void setFlags(int num) {
        //使用每个数的低三位作为byte内的映射
        //例如: 255 = 0x11111111
        //低三位(也就是num & (0x07))为0x111 = 7, 则byte的第7位为1, 表示255已存在
        int i = num & (0x07);
        int t = 0x01 << i ;
        int in = num >> 3;
        int f = flags[in] | t;
        flags[num >> 3] = (byte) f;
//        flags[num >> 3] |= 0x01 << (num & (0x07));
    }

    public static boolean getFlags(int num) {
        int i = num & (0x07);
        int f = flags[num >> 3];
        int t = f >> i;
        int end = t & 0x01;
        //return end == 0x01;
        return (flags[num >> 3] >> (num & (0x07)) & 0x01) == 0x01;
    }
}
