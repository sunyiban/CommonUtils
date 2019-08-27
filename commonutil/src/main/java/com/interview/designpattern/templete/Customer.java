package com.interview.designpattern.templete;

/**
 * @autor sunyiban
 * @date 2019/8/27 15:59
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        AbsTemplete absTemplete = new Chinese();
        absTemplete.templeteMethod();

        AbsTemplete absTemplete1 = new English();
        absTemplete1.templeteMethod();
    }
}
