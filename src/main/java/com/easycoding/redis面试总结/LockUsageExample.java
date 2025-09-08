//package com.easycoding.redis面试总结;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * 分布式锁使用示例
// */
//public class LockUsageExample {
//
//    private static final String LOCK_KEY = "distributed_lock";
//    private static final int LOCK_EXPIRE_TIME = 5000; // 锁过期时间5秒
//
//    public static void main(String[] args) {
//        // 初始化Jedis连接池
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(10);
//        config.setMaxIdle(5);
//        config.setMinIdle(1);
//        JedisPool jedisPool = new JedisPool(config, "localhost", 6379, 2000);
//
//        // 创建分布式锁实例
//        RedisDistributedLock distributedLock = new RedisDistributedLock(jedisPool);
//
//        // 生成唯一请求ID，可使用UUID
//        String requestId = java.util.UUID.randomUUID().toString();
//
//        try {
//            // 尝试获取锁
//            boolean locked = distributedLock.tryGetLock(LOCK_KEY, requestId, LOCK_EXPIRE_TIME);
//            if (locked) {
//                System.out.println("成功获取锁，执行临界区操作...");
//                // 执行需要加锁的业务逻辑
//                Thread.sleep(2000); // 模拟业务操作
//            } else {
//                System.out.println("获取锁失败，无法执行临界区操作");
//            }
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        } finally {
//            // 释放锁
//            boolean released = distributedLock.releaseLock(LOCK_KEY, requestId);
//            if (released) {
//                System.out.println("锁已成功释放");
//            } else {
//                System.out.println("释放锁失败，可能锁已过期或被其他线程持有");
//            }
//            jedisPool.close();
//        }
//    }
//}
