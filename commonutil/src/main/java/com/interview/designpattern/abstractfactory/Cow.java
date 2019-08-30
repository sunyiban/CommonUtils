package com.interview.designpattern.abstractfactory;

/**
 * @autor sunyiban
 * @date 2019/8/30 14:44
 * @descrpition
 */
public class Cow implements Animal {
    @Override
    public void eating() {
        System.out.println("牛在吃草");
    }
}
