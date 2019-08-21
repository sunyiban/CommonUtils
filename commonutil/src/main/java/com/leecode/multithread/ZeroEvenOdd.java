package com.leecode.multithread;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @autor sunyiban
 * @date 2019/7/25 9:21
 * @descrpition 1116 打印零与奇偶数
 * 原理是利用稳步递增，通过三个for循环来控制打印输出，由于0的打印数量和n相同，所以有打印0的方法控制通知打印奇偶数。
 */
public class ZeroEvenOdd {

    private int n;
    private Semaphore semaphoreZero;
    private Semaphore semaphoreEven;
    private Semaphore semaphoreOdd;


    public ZeroEvenOdd(int n) {
        this.n = n;
        semaphoreZero = new Semaphore(1);
        semaphoreOdd = new Semaphore(0);
        semaphoreEven = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer
    public void zero(IntConsumer printNumber) throws InterruptedException {
        // 打印奇偶数都在这里控制
        for (int i = 1; i <= n; i++) {
            // 获取信号
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i = i+2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i = i+2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

}
