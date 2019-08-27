package com.interview.designpattern.command;

/**
 * @autor sunyiban
 * @date 2019/8/27 17:59
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        waiter.setChangfen(new ChangFen(new ChangFenChef()));
        waiter.chooseChangFen();

        waiter.setReganmian(new ReGanMian(new ReGanMianChef()));
        waiter.chooseReGanMian();
    }
}
