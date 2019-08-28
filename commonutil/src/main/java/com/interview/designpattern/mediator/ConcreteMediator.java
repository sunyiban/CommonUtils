package com.interview.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/28 16:31
 * @descrpition
 */
public class ConcreteMediator implements Mediator {
    public List<Colleague> list = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!list.contains(colleague)) {
            list.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        for (Colleague co : list) {
            if (!co.equals(colleague)) {
                co.receive();
            }
        }
    }
}
