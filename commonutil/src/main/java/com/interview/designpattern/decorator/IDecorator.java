package com.interview.designpattern.decorator;

public abstract class IDecorator implements Origin {
    protected Origin origin;

    public IDecorator(Origin origin) {
        this.origin = origin;
    }

    public abstract void display();
}
