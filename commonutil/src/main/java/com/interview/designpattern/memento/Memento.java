package com.interview.designpattern.memento;

/**
 * @autor sunyiban
 * @date 2019/8/29 14:15
 * @descrpition
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
