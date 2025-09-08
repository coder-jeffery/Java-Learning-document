//package com.easycoding.redis.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RedisService {
//
//    @Autowired
//    private RedisTemplate<String,Object> redisTemplate;
//
//    public Boolean callString(String key, Object value){
//
//        return redisTemplate.opsForValue().setIfAbsent(key, value);
//    }
//}
