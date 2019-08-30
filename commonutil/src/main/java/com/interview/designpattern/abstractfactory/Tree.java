package com.interview.designpattern.abstractfactory;

/**
 * @autor sunyiban
 * @date 2019/8/30 14:46
 * @descrpition
 */
public class Tree implements Plant {
    @Override
    public void grow() {
        System.out.println("长了一棵树");
    }
}
