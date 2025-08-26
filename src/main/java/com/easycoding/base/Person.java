package com.easycoding.base;

import lombok.Builder;
import lombok.ToString;


public class Person {

    public static void main(String[] args) {
        Child child = Child.builder().address("china").name("tom").age(20).build();
        System.out.println(child);
        System.out.println(child.toString());
    }
}

@ToString  //定义个对象的字符串表现形式 Object类定义规则类的全路径名+@+对象哈希码
@Builder
class Child{
    String name;
    int age;
    String address;


}

/**
 * Object内部方法：
 * toString
 * hashCode
 * equals
 * clone
 * finalized  GC调用该方法 自救 引用计数法
 * wait
 * notify
 * notifyAll
 *
 * clone >>>深克隆 返回一个对象的副本  效率高  重写需要实现Cloneable接口
 *
 * */
