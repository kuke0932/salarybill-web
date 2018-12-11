package com.htcs.wework.common.util.cache;


import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaokaiyuan
 * @create 2017-12-11 10:01
 **/
public class MapCacheImpl implements CacheUtils.CustomCache {
    private static Map<String, Object> cache = new HashMap<>(1024);

    private static MapCacheImpl mapCacheUtil = new MapCacheImpl();

    private MapCacheImpl() {

    }

    public static MapCacheImpl getInstance() {
        return mapCacheUtil;
    }

    @Override
    public void put(String cacheName, String key, Object value) {
        throw new NotImplementedException("not implemented");
    }

    @Override
    public void put(String cacheName, String key, Object value, long val, TimeUnit timeUnit) {
        throw new NotImplementedException("not implemented");
    }

    @Override
    public void put(String key, Object value) {
        cache.put(key, value);
    }

    @Override
    public void put(String key, Object value, long val, TimeUnit timeUnit) {
        throw new NotImplementedException("not implemented");
    }

    @Override
    public Object get(String cacheName, String key) {
        throw new NotImplementedException("not implemented");
    }

    @Override
    public Object get(String key) {
        return cache.get(key);
    }

    @Override
    public void remove(String cacheName, String key) {
        throw new NotImplementedException("not implemented");
    }


    @Override
    public void remove(String key) {
        cache.remove(key);
    }
}
