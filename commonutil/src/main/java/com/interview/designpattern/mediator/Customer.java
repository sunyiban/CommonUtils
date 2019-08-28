package com.interview.designpattern.mediator;

/**
 * @autor sunyiban
 * @date 2019/8/28 16:30
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague c1 = new ConcreteColleague1();
        Colleague c2 = new ConcreteColleague2();
        mediator.register(c1);
        mediator.register(c2);
        c1.send();
        System.out.println("_-----------------------");
        c2.send();

    }
}
