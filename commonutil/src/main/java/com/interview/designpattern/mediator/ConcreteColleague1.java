package com.interview.designpattern.mediator;

/**
 * @autor sunyiban
 * @date 2019/8/28 16:28
 * @descrpition
 */
public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("1号，收到了信息");
    }

    @Override
    public void send() {
        System.out.println("1号，发出了信息");
        mediator.relay(this);
    }
}
