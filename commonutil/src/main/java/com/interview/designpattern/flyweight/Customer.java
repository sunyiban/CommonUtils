package com.interview.designpattern.flyweight;

/**
 * @autor sunyiban
 * @date 2019/8/26 15:04
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        IFlyWeight iFlyWeightA = flyWeightFactory.createFlyWeight("a");
        IFlyWeight iFlyWeightB = flyWeightFactory.createFlyWeight("a");
        IFlyWeight iFlyWeightC = flyWeightFactory.createFlyWeight("B");
        iFlyWeightA.handle(new UnShareFlyWeight("hello a"));
        iFlyWeightB.handle(new UnShareFlyWeight("hello b"));
        iFlyWeightC.handle(new UnShareFlyWeight("hello c"));
    }
}
