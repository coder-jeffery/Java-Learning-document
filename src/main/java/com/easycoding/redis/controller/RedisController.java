package com.easycoding.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/string")
    public Boolean setValue(@RequestParam("key") String key,
                            @RequestParam("value") String value) {
//        redisTemplate.opsForValue().set(key,value);
//        Duration duration = Duration.ofSeconds(10);
//        redisTemplate.opsForValue().setIfAbsent("taobao","maijiaxiu", duration);
        // 获取 String 操作对象
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        // 新增/修改
        valueOps.set("name", "张三");
        // 设置过期时间（5分钟）
        valueOps.set("age", 20, 5, TimeUnit.MINUTES);
        // 获取
        Object name = valueOps.get("name");
        // 自增（整数）
        valueOps.increment("count"); // 自增1
        valueOps.increment("score", 5); // 自增5
        valueOps.decrement("count"); // 自减1
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    @GetMapping("/hash")
    public Map<String, Object> hash() {
        // 获取 Hash 操作对象
        HashOperations<String, Object, Object> hashOps = redisTemplate.opsForHash();

        // 新增/修改 hash 中的字段
        hashOps.put("user:1001", "id", 1001);
        hashOps.put("user:1001", "name", "张三");
        hashOps.put("user:1001", "age", 20);

        Map<Object, Object> userMap = new HashMap<>();
        userMap.put("id", 1002);
        userMap.put("name", "李四");
        hashOps.putAll("user:1002", userMap);

        Object userName = hashOps.get("user:1001", "name");
        Map<Object, Object> user = hashOps.entries("user:1001");
        hashOps.delete("user:1001", "age");
        return Map.of("user", user, "userName", userName);
    }

    @GetMapping("/list")
    public List<?> list() {
        // 获取 List 操作对象
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        // 从左侧添加元素
        listOps.leftPush("mylist", "A");
        listOps.leftPushAll("mylist", "B", "C"); // 批量添加
        // 从右侧添加元素
        listOps.rightPush("mylist", "D");
        // 获取指定范围的元素（0到-1表示所有）
        List<Object> allElements = listOps.range("mylist", 0, -1);
        // 获取列表长度
        Long size = listOps.size("mylist");
        // 弹出左侧第一个元素
        Object leftElement = listOps.leftPop("mylist");
        // 弹出右侧第一个元素
        Object rightElement = listOps.rightPop("mylist");
        return allElements;
    }

    @GetMapping("/set")
    public SetOperations<String, Object> set(){
        // 获取 Set 操作对象
        SetOperations<String, Object> setOps = redisTemplate.opsForSet();
        // 添加元素
        setOps.add("myset", "A", "B", "C");
        // 获取集合所有元素
        Set<Object> allElements = setOps.members("myset");
        // 判断元素是否在集合中
        Boolean isMember = setOps.isMember("myset", "A");
        // 移除元素
        setOps.remove("myset", "A");
        // 集合交集
        Set<Object> intersect = setOps.intersect("myset", "otherset");
        // 集合并集
        Set<Object> union = setOps.union("myset", "otherset");
        return setOps;
    }

    @GetMapping("/zset")
    public ZSetOperations<String, Object> zset(){
        // 获取 ZSet 操作对象
        ZSetOperations<String, Object> zSetOps = redisTemplate.opsForZSet();
        // 添加元素（值 + 分数）
        zSetOps.add("rank", "张三", 90.5);
        zSetOps.add("rank", "李四", 85.0);
        zSetOps.add("rank", "王五", 95.0);
        // 获取指定范围的元素（按分数升序，0到-1表示所有）
        Set<Object> allElements = zSetOps.range("rank", 0, -1);
        // 获取指定范围的元素（带分数）
        Set<ZSetOperations.TypedTuple<Object>> elementsWithScore = zSetOps.rangeWithScores("rank", 0, -1);
        // 按分数范围查询（80分到90分）
        Set<Object> byScore = zSetOps.rangeByScore("rank", 80, 90);
        // 增加元素的分数
        zSetOps.incrementScore("rank", "张三", 2.5); // 张三的分数变为93.0
        // 获取元素排名（升序，从0开始）
        Long rank = zSetOps.rank("rank", "张三");
        return zSetOps;
    }

    @GetMapping("/common")
    public void common() {
        // 删除键
        redisTemplate.delete("name");
        // 判断键是否存在
        Boolean exists = redisTemplate.hasKey("name");
        // 设置键过期时间
        redisTemplate.expire("name", 10, TimeUnit.SECONDS);
        // 获取键的剩余过期时间
        Long expire = redisTemplate.getExpire("name");
        // 序列化键（获取 Redis 中实际存储的键名）
        byte[] serializedKey = redisTemplate.getKeySerializer().serialize(null);
    }
}
