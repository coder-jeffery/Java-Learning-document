package com.easycoding.base.collections;

/**
 * @author chunming.jiang
 * @Description //TODO $
 * @date $ 2019/11/21$
 **/
public class ArrayDemo {

    public static  void main(String [] args){
        //region 数组
        System.out.println("************数组实现方式一*****************");
        int [] arr = {1,2};
        for(int i:arr){
            System.out.println(i);
        }
        System.out.println("************数组实现方式二*****************");
        int [] arr2 = new int[]{1,2};
        for(int a:arr2){
            System.out.println(String.valueOf(a));
        }
        System.out.println("************数组实现方式三*****************");
        int [] arr3 = new int[3];
        System.out.println(arr3.length);
        System.out.println("************二维数组*****************");
        int [][]  dimensionsArray = {
            {1,2},
            {4,5}
        };
        for(int[] i:dimensionsArray){
            for(int j:i){
                System.out.println(j);
            }
        }

    }
}
