package com.ougen.cache_write.linkedcache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:ougen
 * @date:2018/8/239:27
 */
public class LinkedHashCache<K,V> extends LinkedHashMap<K,V> {

    private int maxCacheSize ;

    public LinkedHashCache(){
        this(10);
    }

    LinkedHashCache(int maxCacheSize){
        this.maxCacheSize=maxCacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size() > maxCacheSize;
    }
}
