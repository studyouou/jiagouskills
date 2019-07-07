package com.ougen.map_read;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author:ougen
 * @date:2018/8/2515:04
 */
public class CurrentHashMap {
    private static ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        concurrentHashMap.get(1);
        concurrentHashMap.put(1,1);
    }
}
