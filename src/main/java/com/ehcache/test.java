package com.ehcache;

import com.base.User;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;

public class test {
    public static void main(String[] args){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        //手动初始化
        cacheManager.init();
        //堆内缓存
        ResourcePoolsBuilder resource = ResourcePoolsBuilder.heap(10);
        //堆外缓存 缺点：对象必须要序列化，键和值必须实现Serializable接口
//        ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(200, MemoryUnit.MB);

        CacheConfiguration<Long, User> config = CacheConfigurationBuilder
                .newCacheConfigurationBuilder(Long.class, User.class, resource).build();

        //创建缓存对象
        Cache<Long, User> cache = cacheManager.createCache("userInfoCache",
                CacheConfigurationBuilder.newCacheConfigurationBuilder(config));
        //写入缓存
        cache.put(10001L, new User());
        //读取缓存
        System.out.println(cache.get(10001L));

        //再程序关闭前，需要手动释放资源
        cacheManager.close();
    }
}
