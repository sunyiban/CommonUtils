package com.interview.designpattern.strategy;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:04
 * @descrpition
 */
public class SteamedCrab implements CrabCooking {
    @Override
    public void cooking() {
        System.out.println("清蒸大闸蟹");
    }
}
