package com.easycoding.redis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    //方式一
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return template;
    }


//    // 配置自定义ObjectMapper
//    @Bean
//    public ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        // 注册JDK8模块，支持Optional等类型
//        objectMapper.registerModule(new Jdk8Module());
//        objectMapper.registerModule (new JavaTimeModule());
//        // 禁用空Bean序列化错误
//        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//        // 可以添加其他配置，如日期格式化
//        // objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return objectMapper;
//    }
//
//
//    // 配置RedisTemplate，明确使用自定义的ObjectMapper
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(
//            RedisConnectionFactory connectionFactory, ObjectMapper objectMapper) {  // 注入上面定义的ObjectMapper
//        // 使用自定义ObjectMapper创建序列化器
//        GenericJackson2JsonRedisSerializer valueSerializer =
//                new GenericJackson2JsonRedisSerializer(objectMapper);
//        // 字符串序列化器用于键
//        StringRedisSerializer keySerializer = new StringRedisSerializer();
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        // 配置键和值的序列化器
//        template.setKeySerializer(keySerializer);
//        template.setValueSerializer(valueSerializer);
//        template.setHashKeySerializer(keySerializer);
//        template.setHashValueSerializer(valueSerializer);
//        // 初始化参数设置
//        template.afterPropertiesSet();
//        return template;
//    }

//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(factory);
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
////
////
////
////        RedisTemplate<String, Object> template = new RedisTemplate<>();
////        template.setConnectionFactory(connectionFactory);
//
//        // 使用 String 序列化器处理键
//        StringRedisSerializer stringSerializer = new StringRedisSerializer();
//        redisTemplate.setKeySerializer(stringSerializer);
//        redisTemplate.setHashKeySerializer(stringSerializer);
//
//        // 使用 Jackson 序列化器处理值（排除类型信息，避免序列化内部类）
//        GenericJackson2JsonRedisSerializer jacksonSerializer = new GenericJackson2JsonRedisSerializer();
//        redisTemplate.setValueSerializer(jacksonSerializer);
//        redisTemplate.setHashValueSerializer(jacksonSerializer);
//
//        redisTemplate.afterPropertiesSet();
//
//        return  redisTemplate;
//    }
}
