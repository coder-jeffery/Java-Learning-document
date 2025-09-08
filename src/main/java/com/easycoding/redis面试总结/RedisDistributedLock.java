//package com.easycoding.redis面试总结;
//
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import java.util.Collections;
//
///**
// * Redis分布式锁实现
// */
//public class RedisDistributedLock {
//
//    private static final String LOCK_SUCCESS = "OK";
//    private static final String SET_IF_NOT_EXIST = "NX";
//    private static final String SET_WITH_EXPIRE_TIME = "PX";
//    private static final Long RELEASE_SUCCESS = 1L;
//
//    private JedisPool jedisPool;
//
//    public RedisDistributedLock(JedisPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }
//
//    /**
//     * 获取分布式锁
//     * @param lockKey 锁的键值
//     * @param requestId 唯一标识(用于标识当前获取锁的客户端)
//     * @param expireTime 锁的过期时间(毫秒)
//     * @return 是否获取成功
//     */
//    public boolean tryGetLock(String lockKey, String requestId, int expireTime) {
//        RedisProperties.Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            // 使用SET命令的NX和PX参数实现分布式锁
//            String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
//            return LOCK_SUCCESS.equals(result);
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//    }
//
//    /**
//     * 释放分布式锁
//     * @param lockKey 锁的键值
//     * @param requestId 唯一标识
//     * @return 是否释放成功
//     */
//    public boolean releaseLock(String lockKey, String requestId) {
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            // 使用Lua脚本保证释放锁的原子性
//            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//            Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
//
//            return RELEASE_SUCCESS.equals(result);
//        } finally {
//            if (jedis != null) {
//                jedis.close();
//            }
//        }
//    }
//}
