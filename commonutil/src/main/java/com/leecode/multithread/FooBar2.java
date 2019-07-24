package com.leecode.multithread;

import java.util.concurrent.Semaphore;

/**
 * @autor sunyiban
 * @date 2019/7/24 15:58
 * @descrpition
 */
public class FooBar2 {

    private Semaphore s1, s2;
    private int n;

    public FooBar2 (int n) {
        this.n = n;
        // 第一个执行的要有一个容量，否则获取不到
        s1 = new Semaphore(1);
        // 第二个执行的0容量，保证不会第一次执行
        s2 = new Semaphore(0);
    }

    public void foo(Runnable foo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s1.acquire();
            foo.run();
            s2.release();
        }
    }

    public void bar(Runnable bar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            bar.run();
            s1.release();
        }
    }

    public static void main(String[] args) {
        FooBar2 fooBar2 = new FooBar2(10);

        new Thread(() -> {
            try {
                fooBar2.foo(() -> System.out.println("this is foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        new Thread(() -> {
            try {
                fooBar2.bar(() -> {
                    System.out.println("this is bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
