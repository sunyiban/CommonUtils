package com.interview.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/28 17:34
 * @descrpition
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}
