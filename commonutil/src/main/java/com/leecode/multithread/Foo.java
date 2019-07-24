package com.leecode.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @autor sunyiban
 * @date 2019/7/24 11:19
 * @descrpition 1114 按顺打印
 */
public class Foo {
    private Semaphore semaphoreOne = new Semaphore(0);
    private Semaphore semaphoreTwo = new Semaphore(0);

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphoreOne.release();
    }

    public void second(Runnable printSecone) throws InterruptedException {
        semaphoreOne.acquire();
        printSecone.run();
        semaphoreTwo.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphoreTwo.acquire();
        printThird.run();
    }

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        foo.first(new Runnable() {
            public void run() {
                System.out.println("this is one");
            }
        });

        foo.second(new Runnable() {
            public void run() {
                System.out.println("this is two");
            }
        });

        foo.third(new Runnable() {
            public void run() {
                System.out.println("this is three");
            }
        });
    }

}
