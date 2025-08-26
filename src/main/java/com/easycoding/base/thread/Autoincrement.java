package com.easycoding.base.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Autoincrement {
    public static void main(String[] args) {
        long start  =  System.currentTimeMillis();
        System.out.println("use times:" + start);
        AtomicInteger i = new AtomicInteger();
        for (int j = 0; j < 10000; j++) {
            System.out.println("***" + i.getAndIncrement());
        }
        System.out.println(("use times:" + (System.currentTimeMillis() - start)));
        //AtomicInteger -> unsafe -> cas -> aba
    }
}
