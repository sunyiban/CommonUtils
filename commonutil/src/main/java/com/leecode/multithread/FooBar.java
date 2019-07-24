package com.leecode.multithread;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @autor sunyiban
 * @date 2019/7/24 14:00
 * @descrpition 1115交替打印foobar
 */
public class FooBar {

    private BlockingQueue<Integer> blockingQueueFoo;
    private BlockingQueue<Integer> blockingQueueBar;

    private int n;

    public FooBar(int n) {
        this.n = n;
        blockingQueueBar = new LinkedBlockingDeque();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        blockingQueueFoo = new LinkedBlockingQueue(arrayList);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            blockingQueueFoo.take();
            printFoo.run();
            blockingQueueBar.put(i);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            blockingQueueBar.take();
            printBar.run();
            blockingQueueFoo.put(i);
        }
    }

    public static void main(String[] args) throws Exception {
        FooBar foobar = new FooBar(10);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foobar.bar(() -> {
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
                    foobar.foo(() -> {
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
