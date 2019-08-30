package com.leecode.multithread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @autor sunyiban
 * @date 2019/8/29 17:09
 * @descrpition
 */
public class H2O {

    private Semaphore hydrogen = new Semaphore(2);
    private Semaphore oxygen = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException, BrokenBarrierException {
        try {
            hydrogen.acquire();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            oxygen.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException, BrokenBarrierException {
        try {
            oxygen.acquire(2);
            // releaseOxygen.run() outputs "H". Do not change or remove this line.
            releaseOxygen.run();
            hydrogen.release(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        H2O h2O = new H2O();
        for (int n = 0; n <= 50; n++) {
            h2O.hydrogen(() -> {
                    System.out.print("H");
            });

            h2O.oxygen(() -> {
                    System.out.print("O");
            });
        }
    }
}
