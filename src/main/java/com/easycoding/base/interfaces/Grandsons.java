package com.easycoding.base.interfaces;

public class Grandsons implements Grandson {


    public static void main(String[] args) {
        Grandsons grandsons  = new Grandsons();
        grandsons.eat();
        grandsons.walk();
        grandsons.swim();
        System.out.println("build new grandson");
    }

    @Override
    public void walk() {
        System.out.println("Grandsons normal method walk");
    }

    @Override
    public void swim() {
        System.out.println("Grandsons abstract swim");
    }

    @Override
    public void eat() {
        System.out.println("Grandsons normal method eat");
    }
}
