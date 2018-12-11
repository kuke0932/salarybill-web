package com.htcs.wework.common.util.cache;

import com.htcs.wework.common.util.SpringContextUtils;

import java.util.concurrent.TimeUnit;

public class CacheUtils {

    public static CustomCache getInstance(CacheType type) {
        switch (type) {
            case REDIS:
                return SpringContextUtils.getApplicationContext().getBean("redisCacheImpl", RedisCacheImpl.class);
            case EHCACHE:
                return EhcacheImpl.getInstance();
            case MAP:
                return MapCacheImpl.getInstance();
            default:
                return null;
        }
    }

    /**
     *
     */
    public enum CacheType {
        REDIS,
        EHCACHE,
        MAP
    }

    public interface CustomCache {
        public void put(String cacheName, String key, Object value);

        public void put(String cacheName, String key, Object value, long val, TimeUnit timeUnit);

        public void put(String key, Object value);

        public void put(String key, Object value, long val, TimeUnit timeUnit);


        public Object get(String cacheName, String key);

        public Object get(String key);

        public void remove(String cacheName, String key);

        public void remove(String key);

    }
}