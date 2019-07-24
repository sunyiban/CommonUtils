package com.leecode.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @autor sunyiban
 * @date 2019/7/24 13:37
 * @descrpition 1114.按序打印 第三种实现
 */
public class Foo2 {

    public Foo2(){}

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionOne = reentrantLock.newCondition();
    private Condition conditionTwo = reentrantLock.newCondition();
    private Condition conditionThree = reentrantLock.newCondition();
    private int state = 1;

    public void first(Runnable first) throws InterruptedException {
        reentrantLock.lock();

        try {
            if (state != 1) {
                conditionOne.await();
            }

            first.run();
            state = 2;
            conditionTwo.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    public void second(Runnable second) throws InterruptedException {
        reentrantLock.lock();

        try {
            if (state != 2) {
                conditionTwo.await();
            }
            second.run();
            state = 3;
            conditionThree.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void third(Runnable third) throws InterruptedException {
        reentrantLock.lock();

        try {
            if (state != 3) {
                conditionThree.await();
            }

            third.run();
        } finally {
            reentrantLock.unlock();
        }

    }

    public static void main(String[] args) throws Exception {
        Foo2 foo2 = new Foo2();

        foo2.first(() -> {
            System.out.println("this is one");
        });

        foo2.second(() -> {
            System.out.println("this is two");
        });

        foo2.third(() -> {
            System.out.println("this is third");
        });
    }

}
