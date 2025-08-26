package com.easycoding.base.rewritereload;

public class Animal {

    //重载:同一个类 方法名相同  参数不同 返回值相同
    public void sleep(){
        System.out.println("Animal sleep");
    }

    private void sleep(long millisecondsSleep){
        System.out.println("Animal sleep "+millisecondsSleep);
    }

    private void sleep(float weight){
        System.out.println("Animal sleep "+weight);
    }

}
