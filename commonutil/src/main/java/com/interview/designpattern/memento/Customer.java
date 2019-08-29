package com.interview.designpattern.memento;

/**
 * @autor sunyiban
 * @date 2019/8/29 14:20
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        originator.setState("s0");
        System.out.println("初始状态:" + originator.getState());
        caretaker.setMemento(originator.createMemento());
        originator.setState("s1");
        System.out.println("新的状态:" + originator.getState());
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态：" + originator.getState());
    }
}
