package com.leecode.multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @autor sunyiban
 * @date 2019/7/25 13:38
 * @descrpition
 */
public class ZeroEvenOdd1 {

    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionZero = lock.newCondition();
    private Condition conditionOdd = lock.newCondition();
    private Condition conditionEven = lock.newCondition();
    private int flag = 0;

    public ZeroEvenOdd1(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int j = 1; j <= n; j++) {
            lock.lock();
            try {
                if (flag != 0) {
                    conditionZero.await();
                }
                // 打印0然后等待
                printNumber.accept(0);
                // 这里通知打印奇偶数
                if (j % 2 == 0) {
                    flag = 2;
                    conditionEven.signal();
                } else {
                    flag = 1;
                    conditionOdd.signal();
                }

            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i+2) {
            lock.lock();
            try {
                if (flag != 1) {
                    conditionOdd.await();
                }
                flag = 0;
                printNumber.accept(i);
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i+2) {
            lock.lock();
            try {
                if (flag != 2) {
                    conditionEven.await();
                }
                flag = 0;
                printNumber.accept(i);
                conditionZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd1 zeroEvenOdd1 = new ZeroEvenOdd1(5);

        new Thread(() -> {
            try {
                zeroEvenOdd1.zero((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd1.odd((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                zeroEvenOdd1.even((x) -> System.out.println(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
