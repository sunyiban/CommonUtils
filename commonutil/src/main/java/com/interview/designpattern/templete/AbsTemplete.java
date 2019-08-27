package com.interview.designpattern.templete;

import java.sql.DriverPropertyInfo;

/**
 * @autor sunyiban
 * @date 2019/8/27 15:53
 * @descrpition
 */
public abstract class AbsTemplete {
    public void templeteMethod() {
        eating();
        washing();
        drinking();
        doOtherThing();
        doOtherThing1();
    }

    public void eating() {
        System.out.println("开始吃饭");
    }

    public void washing() {
        System.out.println("开始洗漱");
    }

    public void drinking() {
        System.out.println("开始喝水");
    }

    public abstract void doOtherThing();

    public void doOtherThing1() {
        System.out.println("特定的事");
    }
}
