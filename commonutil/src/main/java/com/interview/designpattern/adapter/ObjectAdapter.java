package com.interview.designpattern.adapter;

/**
 * @autor sunyiban
 * @date 2019/8/26 9:48
 * @descrpition 适配对象
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void target() {
        adaptee.adaptee();
    }
}
