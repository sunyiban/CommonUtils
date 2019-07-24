package com.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @autor sunyiban
 * @date 2019/7/24 14:42
 * @descrpition
 */
public class ReentrantLockTest {

    private ReentrantLock lock = new ReentrantLock();
    private Condition barCondition = lock.newCondition();
    private Condition fooCondition = lock.newCondition();
    private volatile boolean flag = true;

    public void bar(Runnable runnable) throws Exception {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                if (flag) {
                    flag = false;
                    fooCondition.await();
                }
                runnable.run();
                barCondition.signal();

            } finally {
                lock.unlock();
            }

        }
    }

    public void foo(Runnable runnable) throws Exception {
        for (int i = 0; i < 10; i++) {
            lock.lock();
            try {
                if (!flag) {
                    flag = true;
                    barCondition.await();
                }
                runnable.run();
                fooCondition.signal();

            } finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) throws Exception {

        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();



    }

}
