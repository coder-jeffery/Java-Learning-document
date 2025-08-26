package com.easycoding.base.collections;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/21$
 **/

import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *  栈： 先进后出 或者说 后进先出  数组大小未知 每次插入需要扩充需要把旧数组赋值给新数组 性能消耗 使用贪心算法，数组每次被填满后，加入下一个元素时，把数组拓展成现有数组的两倍大小
 *  队列：先进先出
 *
 *  栈 ADT顺序 栈的应用 栈与递归
 *      ArrayList和LinkList支持栈操作 操作栈顶元素 栈本身是一个线性表 仅限表尾插入和删除 LIFO
 *      递归调用就是栈 栈有后进先出特点 递归调用实质就是循环调用
 *      LIFO 后进先出 修改栈顶元素
 *
 * */
public class StackDemo {
    //String [] args 专门接收命令行参数 方便外面的数据引入到main函数中  入口函数不能用abstract修饰
    public static   void main(String [] args){
        //region 入栈 出栈演示
        System.out.println("********入栈顺序：1 2 3 4 **********");
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
//        System.out.println(args[0]);
        System.out.println("********入栈顺序：4 3 2 1  **********");
        //endregion

        //region 数组实现入栈 出栈
        int [] arr = {1,2,3,4,5,6,7,8};
        for(int i=0;i<arr.length;i++){
            System.out.printf(String.valueOf(arr[i]+" "));
        }
        //endregion

//        Stream<Double> stream = Stream.generate(Math::random);
//        stream.forEach(System.out::println);

        Supplier<Integer> supplier = ()->1;
        Consumer<String> consumer = (a)-> System.out.println(a);
        System.out.println(supplier.get());
        consumer.accept("testing测试代码操作.....");

    }

}
