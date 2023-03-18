package com.dev.springbootgraphqlrestapi.utils;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.dataloader.BatchLoader;
import org.dataloader.CacheMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class CustomGuavaBasedCache<U, V> implements CacheMap<U, V>{
    private static final Logger LOG = LoggerFactory.getLogger(CustomGuavaBasedCache.class);



    private Cache<U, V> cache;

    public CustomGuavaBasedCache(long maxCacheSize, long expiryInSeconds) {
        this.cache = CacheBuilder
                .newBuilder()
                .maximumSize(maxCacheSize)
                .expireAfterWrite(expiryInSeconds, TimeUnit.SECONDS)
                .removalListener(notification -> LOG.info("Key {} got removed, because: {}", notification.getKey(), notification.getCause()))
                .build();
    }

    @Override
    public boolean containsKey(U key) {
        return cache.getIfPresent(key) != null;
    }

    @Override
    public CompletableFuture<V> get(U key) {
        return (CompletableFuture<V>) cache.getIfPresent(key);
    }

    @Override
    public CacheMap<U, V> delete(U key) {
        cache.invalidate(key);
        return this;
    }

    @Override
    public CacheMap<U, V> clear() {
        cache.invalidateAll();
        return this;
    }



    @Override
    public Collection<CompletableFuture<V>> getAll() {
      return null;
    }

    @Override
    public CacheMap<U, V> set(U key, CompletableFuture<V> value) {
        cache.put(key, (V) value);
        return this;
    }
}
