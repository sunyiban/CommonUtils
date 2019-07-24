package com.leecode.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * @autor sunyiban
 * @date 2019/7/24 11:49
 * @descrpition 1114.按序打印第二种实现
 */
public class Foo1 {
    private CountDownLatch countDownLatchOne = new CountDownLatch(1);
    private CountDownLatch countDownLatchTwo = new CountDownLatch(1);

    public Foo1(){}

    public void first(Runnable first) throws InterruptedException {
        first.run();
        countDownLatchOne.countDown();
    }

    public void second(Runnable second) throws InterruptedException {
        countDownLatchOne.await();
        second.run();
        countDownLatchTwo.countDown();
    }

    public void third(Runnable third) throws InterruptedException {
        countDownLatchTwo.await();
        third.run();
    }

    public static void main(String[] args) throws Exception {
//        Foo1 foo1 = new Foo1();
//
//        foo1.first(() -> {
//            System.out.println("this is one");
//        });
//
//        foo1.second(() -> {
//            System.out.println("this is two");
//        });
//
//        foo1.third(() -> {
//            System.out.println("this is three");
//        });


        // countdownlatch.count()必须写在await()方法前面，否则无法到达。
        CountDownLatch countDownLatch = new CountDownLatch(2);

        System.out.println("this is start");
        countDownLatch.await();

        countDownLatch.countDown();
        System.out.println("this is first countdown");
        countDownLatch.countDown();

        System.out.println("this is end");

    }

}
