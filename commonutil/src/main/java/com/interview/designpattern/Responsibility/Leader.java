package com.interview.designpattern.Responsibility;

/**
 * @autor sunyiban
 * @date 2019/8/28 9:57
 * @descrpition
 */
public abstract class Leader {
    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    public abstract  void handle(int days);
}
