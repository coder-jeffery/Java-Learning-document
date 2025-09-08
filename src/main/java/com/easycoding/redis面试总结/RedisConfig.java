//package com.easycoding.redis面试总结;
//
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public JedisPool jedisPool(RedisProperties redisProperties) {
//        // 获取Jedis配置
//        RedisProperties.Jedis jedisProperties = redisProperties.getJedis();
//        RedisProperties.Pool poolProperties = jedisProperties.getPool();
//
//        // 配置连接池
//        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(poolProperties.getMaxActive());
//        poolConfig.setMaxIdle(poolProperties.getMaxIdle());
//        poolConfig.setMinIdle(poolProperties.getMinIdle());
//        poolConfig.setMaxWaitMillis(poolProperties.getMaxWait().toMillis());
//
//        // 创建JedisPool
//        return new JedisPool(poolConfig,
//                redisProperties.getHost(),
//                redisProperties.getPort(),
//                redisProperties.getTimeout().toMillis());
//    }
//}