package com.interview.designpattern.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor sunyiban
 * @date 2019/8/27 14:39
 * @descrpition
 */
public class Bag implements Commodity{

    private String color;

    private List<Commodity> list = new ArrayList<>();

    public void add(Commodity shoping) {
        list.add(shoping);
    }

    @Override
    public double calculate() {
        double d = 0;
        for (Commodity shoping : list) {
            d += shoping.calculate();
        }
        return d;
    }

    @Override
    public void show() {
        for (Commodity shoping : list) {
            shoping.show();
        }
    }
}
