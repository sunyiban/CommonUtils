package com.interview.designpattern.strategy;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:05
 * @descrpition
 */
public class BraisedCrab implements CrabCooking {
    @Override
    public void cooking() {
        System.out.println("红烧大闸蟹");
    }
}
