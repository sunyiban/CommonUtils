package com.interview.designpattern.templete;

/**
 * @autor sunyiban
 * @date 2019/8/27 15:58
 * @descrpition
 */
public class Chinese extends AbsTemplete {
    @Override
    public void doOtherThing() {
        System.out.println("中国人的事");
    }

    @Override
    public void doOtherThing1() {
        System.out.println("中国人重写的事");
    }
}
