package com.interview.designpattern.memento;

/**
 * @autor sunyiban
 * @date 2019/8/29 14:19
 * @descrpition
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
