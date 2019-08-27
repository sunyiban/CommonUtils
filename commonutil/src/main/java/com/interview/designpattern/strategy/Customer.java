package com.interview.designpattern.strategy;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:07
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen(new SteamedCrab());
        kitchen.cook();

        kitchen = new Kitchen(new BraisedCrab());
        kitchen.cook();
    }
}
