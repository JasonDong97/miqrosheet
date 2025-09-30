package com.era.miqrosheet.infra.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class RedisHelper<K, V> {

    private final RedisTemplate<K, V> redisTemplate;

    // String 操作
    public void set(K key, V value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public void set(K key, V value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public V get(K key) {
        return redisTemplate.opsForValue().get(key);
    }

    public Boolean delete(K key) {
        return redisTemplate.delete(key);
    }

    public Boolean hasKey(K key) {
        return redisTemplate.hasKey(key);
    }

    public Boolean expire(K key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    // Hash 操作
    public void hSet(K key, Object hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public Object hGet(K key, Object hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public Map<Object, Object> hGetAll(K key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public void hDelete(K key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(key, hashKeys);
    }

    // List 操作
    public void lPush(K key, V value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public V lPop(K key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    public List<V> lRange(K key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    // Set 操作
    public void sAdd(K key, V... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    public Set<V> sMembers(K key) {
        return redisTemplate.opsForSet().members(key);
    }

    public Boolean sIsMember(K key, V value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }
}
