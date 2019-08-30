package com.interview.designpattern.proxy;

/**
 * @autor sunyiban
 * @date 2019/8/30 16:36
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new WuHanSpecialty());
        proxy.disPlay();
    }
}
