package com.leecode.multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @autor sunyiban
 * @date 2019/7/24 14:29
 * @descrpition
 */
public class FooBar1 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition one = lock.newCondition();
    private Condition two = lock.newCondition();
    private volatile int flag = 0;
    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (flag != 0) {
                one.await();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            flag = 1;
            printFoo.run();
            two.signalAll();
            lock.unlock();

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            if (flag != 1) {
                two.await();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            flag = 0;
            printBar.run();
            one.signalAll();
            lock.unlock();
        }
    }


    public static void main(String[] args) throws Exception {
        FooBar1 foobar1 = new FooBar1(10);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foobar1.bar(() -> {
                        System.out.println("this is bar");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foobar1.foo(() -> {
                        System.out.println("this is foo");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

        thread2.start();
    }

}
