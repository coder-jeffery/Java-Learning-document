package com.easycoding.base.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author chunming.jiang
 * @Description //TODO
 * @date $ 2019/11/25
 **/
public class ThreadDemo {

    public static void main(String [] args){

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("启动一个线程");
//            }
//        }).start();


//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                System.out.println("启动一个线程");
//            }
//        });
//        thread.start();

        new Thread(() -> System.out.println("启动一个线程")).start();

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.forEach(t-> System.out.println(t+"\t"));

        System.out.println("***************************************************");
//        Random random = new Random();
//        Stream<Integer> stream = Stream.generate(() ->random.nextInt(5));
//        stream.forEach(t-> System.out.println(t));
        new Thread(()-> System.out.println("启动一个线程1")).start();
        IMyInterface iMyInterface = ()-> System.out.println("启动一个线程2");
        iMyInterface.study();
        new Thread(() -> System.out.println("启动一个线程3")).start();

        List<String> listStr = Collections.EMPTY_LIST;
        listStr.forEach(System.out::println);

        Map<String,Object> map  = Collections.EMPTY_MAP;
        map.forEach((k,v) -> System.out.println(k + ":"+ v));

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("采用匿名类");
            }
        });

        new Thread(()-> System.out.println("启动一个线程4"));
        Thread thread = new Thread(()-> System.out.println("xxx"));

        /**
         * 函数接口:
         *      Predicate<T>
         *      Consumer<T>
         *      Function<T,R>
         *      Supplier<T>
         *      UnaryOperator<T>
         *      BinaryOperator<T>
         * */
    }


    @FunctionalInterface
    public interface IMyInterface{
        void study();
    }
}
