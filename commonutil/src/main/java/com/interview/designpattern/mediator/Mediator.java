package com.interview.designpattern.mediator;

public interface Mediator {

    public void register(Colleague colleague);

    public void relay(Colleague colleague);
}
