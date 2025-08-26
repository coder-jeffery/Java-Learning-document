package com.easycoding.base.rewritereload;

public class Pig extends Animal{

    @Override
    public void sleep(){
        System.out.println("call Animal sleep method overwrite");
    }

    public static void main(String[] args) {
        Pig p1=new Pig();
        p1.sleep();
        System.out.println("p1 sleep");
    }

    /**
     * final修饰的类不能有子类 大部分出去安全考虑
     * String
     * */
}
