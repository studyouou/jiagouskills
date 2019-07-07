package com.ougen.sort_write;

import java.util.Map;

/**
 * @author:ougen
 * @date:2018/9/712:59
 */
public class MainDemo {
    public static void main(String[] args) {
       Util.printArr(XuanZeSort.sortByXuanZe(ArrInstance.arr));
       System.out.println();
        Map map = (Map)null;
       Util.printArr(MaoPaoSort.sortArrayByMaoPao(ArrInstance.arr));
       System.out.println();
       Util.printArr(JiShuSort.sortByJiShu(ArrInstance.arr));
    }
}
