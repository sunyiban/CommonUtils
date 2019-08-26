package com.interview.designpattern.adapter;

/**
 * @autor sunyiban
 * @date 2019/8/26 9:49
 * @descrpition 客户类
 */
public class Customer {

    public static void main(String[] args) {
        Target target = new ObjectAdapter(new Adaptee());
        target.target();
    }

}
