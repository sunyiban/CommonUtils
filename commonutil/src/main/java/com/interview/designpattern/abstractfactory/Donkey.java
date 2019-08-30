package com.interview.designpattern.abstractfactory;

/**
 * @autor sunyiban
 * @date 2019/8/30 14:45
 * @descrpition
 */
public class Donkey implements Animal {
    @Override
    public void eating() {
        System.out.println("驴子在吃草");
    }
}
