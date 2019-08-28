package com.interview.designpattern.mediator;

/**
 * @autor sunyiban
 * @date 2019/8/28 16:26
 * @descrpition
 */
public abstract class Colleague {
    protected Mediator mediator;

    public abstract void receive();

    public abstract void send();

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}
