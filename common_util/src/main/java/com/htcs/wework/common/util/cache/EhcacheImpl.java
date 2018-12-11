package com.htcs.wework.common.util.cache;

import com.htcs.wework.common.CacheConstans;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.lang3.NotImplementedException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author htcs
 */
public class EhcacheImpl implements CacheUtils.CustomCache {
    private static final String path = "/config/ehcache.xml";
    private static EhcacheImpl ehCache;
    private URL url;
    private CacheManager manager;

    private EhcacheImpl(String path) {
        url = getClass().getResource(path);
        manager = CacheManager.create(url);
    }

    public static EhcacheImpl getInstance() {
        if (ehCache == null) {
            ehCache = new EhcacheImpl(path);
        }
        return ehCache;
    }

    @Override
    public void put(String cacheName, String key, Object value) {
        Cache cache = getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);
    }

    @Override
    public void put(String cacheName, String key, Object value, long val, TimeUnit timeUnit) {
        Cache cache = getCache(cacheName);
        Element element = null;
        switch (timeUnit) {
            case SECONDS:
                element = new Element(key, value, true, ((Long) val).intValue(), 3600);
                break;
            case MINUTES:
                element = new Element(key, value, true, ((Long) (val * 60)).intValue(), 3600);
                break;
            case HOURS:
                element = new Element(key, value, true, ((Long) (val * 3600)).intValue(), 3600);
                break;
            default:
                throw new NotImplementedException("时间单位必须是秒、分钟、小时的一种");
        }
        cache.put(element);
    }

    @Override
    public void put(String key, Object value) {
        this.put(CacheConstans.DEFAULT_CACHE, key, value);
    }

    @Override
    public void put(String key, Object value, long val, TimeUnit timeUnit) {
        this.put(CacheConstans.DEFAULT_CACHE, key, value, val, timeUnit);
    }

    @Override
    public Object get(String cacheName, String key) {
        Cache cache = getCache(cacheName);
        Element element = cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    @Override
    public Object get(String key) {
        return this.get(CacheConstans.DEFAULT_CACHE, key);
    }

    @Override
    public void remove(String cacheName, String key) {
        getCache(cacheName).remove(key);
    }

    @Override
    public void remove(String key) {
        this.remove(CacheConstans.DEFAULT_CACHE, key);
    }

    public Cache getCache(String cacheName) {
        return manager.getCache(cacheName);
    }


}
