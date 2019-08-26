package com.interview.designpattern.facade;

/**
 * @autor sunyiban
 * @date 2019/8/26 14:12
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.handle();
    }
}
