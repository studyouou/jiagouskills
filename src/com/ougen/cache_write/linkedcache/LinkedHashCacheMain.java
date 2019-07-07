package com.ougen.cache_write.linkedcache;

/**
 * @author:ougen
 * @date:2018/8/239:31
 */
public class LinkedHashCacheMain {
    public static void main(String[] args) {
        LinkedHashCache<String,String> linkedHashCache = new LinkedHashCache<String,String>(4);
        linkedHashCache.put("1","1");
        linkedHashCache.put("2","2");
        linkedHashCache.put("3","3");
        linkedHashCache.put("4","4");
        linkedHashCache.put("5","5");
        linkedHashCache.put("6","6");
        linkedHashCache.put("7","7");
        linkedHashCache.put("8","8");
        linkedHashCache.put("9","9");
        System.out.println(linkedHashCache);
    }
}
