package com.interview.designpattern.memento;

/**
 * @autor sunyiban
 * @date 2019/8/29 14:17
 * @descrpition
 */
public class Originator {
    private String state;

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento m) {
        this.state = m.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
