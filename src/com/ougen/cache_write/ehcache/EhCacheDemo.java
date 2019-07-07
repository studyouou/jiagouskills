package com.ougen.cache_write.ehcache;

import com.ougen.model.Demo;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

/**
 * @author:ougen
 * @date:2018/8/2312:33
 */
public class EhCacheDemo<T> {
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build(true);//这里设置为true，就不用再调用init()方法了
    ResourcePoolsBuilder resource = null;
    CacheConfiguration configuration ;
    Cache<String,T> cache ;
    EhCacheDemo(Class clazz){
//        cacheManager.init();
        resource = ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(20, MemoryUnit.MB);
        configuration = CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class,clazz,resource).build();
        cache = cacheManager.createCache("demoInfoCache",CacheConfigurationBuilder.newCacheConfigurationBuilder(configuration));
    }
    public void cache(String c,T t){
        cache.put(c,t);
    }
    public T get(String id){
        return cache.get(id);
    }
}
