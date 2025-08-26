package com.easycoding.base.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Map {

    public static void main(String[] args) {
        //JUC 高并发集合类  数组或链表 jdk1.8版本以后 顺序查找 O(n)
        //哈希冲突如何解决？
        //为什么使用HashMap? 红黑树 插入 查找 删除 O
        //泊松分布 为什么退化 8

        /**
         * 1.ConcurrentHashMap
         *      java5.0 采用锁分段机制
         * 2.ConcurrentHashMap 和 HashTable区别
         *      JUC包 分段级别 16段
         *
         * 3.ConcurrentHashMap 线程安全实现方式？底层具体实现？
         * 4.CopyOnWriteArrayList
         *
         * Vector HashTable JUC
         *
         * */

        /***
         * 非线程安全集合类
         * 线程安全集合类
         * JUC高并发集合类
         *
         * */

        HashMap map = new HashMap();
        map.put(1, "map value");
        System.out.println(map.get(1));

        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(1, "linkedHashMap value");
        System.out.println(linkedHashMap.get(1));

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1, "concurrentHashMap value");
        System.out.println(concurrentHashMap.get(1));
    }
}
