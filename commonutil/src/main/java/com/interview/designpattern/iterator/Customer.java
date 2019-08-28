package com.interview.designpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/28 17:44
 * @descrpition
 */
public class Customer {
    public static void main(String[] args) {
        ConcreteAggregate list = new ConcreteAggregate();
        list.add("张三");
        list.add("李四");
        list.add("王五");

        Iterator it = list.getIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("first: " + it.first());
    }
}
