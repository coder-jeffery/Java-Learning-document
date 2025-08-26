package com.easycoding.base.collections;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/21$
 **/
public class LambdaDemo {
    public static  void main(String [] args){
        //region java8写法 Lambda表达式基础语法
        Runnable run  =() -> System.out.println("Java8");
        run.run();
        Consumer<String> t = x-> System.out.println(x);
        t.accept("Java11");
        new Thread(() -> System.out.println("lambda is very nice")).start();
        Consumer<String> consumer =  s -> System.out.println(s);
        Supplier<String> supplier =  () -> "test";
        //endregion
        //region 高性能写法
        System.out.println("************lambda表达式*****************");
        //第一种写法
        String [] atp = {"java is okay","kotlin is okay","csharp is okay"};
        List<String> list  = Arrays.asList(atp);
        for(String player:list){
            System.out.println(player);
        }
        //第二种写法
        list.forEach((x)-> System.out.println(x));
        //第三种写法
        list.forEach(System.out::println);
        //endregion
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("***************************************************");
                System.out.println("启动一个线程");
                System.out.println("***************************************************");
            }
        }).start();
        testLambda();//测试lambda表达式
    }
    public static void testLambda(){
//        方法一、
//        匿名类方式实现
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello world is include runnable");
//            }
//        }).start();
//        方法二、
//        new Thread(()-> System.out.println("hello world")).start();
//        方法三、
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello world");
//            }
//        };
//        方法四
//        Runnable r = ()-> System.out.println("hello world");
//        r.run();
        new Thread( ()-> System.out.println("java8 ")).start();
        List<String> languages  = Arrays.asList("java","scala","python");
        languages.forEach(x-> System.out.println(x));
        languages.forEach(System.out::println);
        List<Double> cost  =  Arrays.asList(10.0,20.0,30.0);
        cost.stream().map(x->x+x*0.05).forEach(x-> System.out.println(x));
        System.out.println("***************************************************");
        List<Double> cost2 =  Arrays.asList(10.0,20.0,30.0);
        double allCost = cost.stream().map(x->x+x*0.05).reduce((sum,x)->sum+x).get();
        System.out.println(allCost);
        System.out.println("***************************************************");
        List<Double> cost3 = Arrays.asList(10.0, 20.0,30.0,40.0);
        List<Double> filteredCost = cost3.stream().filter(x -> x > 25.0).collect(Collectors.toList());
        filteredCost.forEach(x -> System.out.println(x));

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动一个线程");
            }
        }).start();
    }

    public static void testStream(){
//        map, filter, limit, sorted, count, min, max, sum, collect

    }
}
