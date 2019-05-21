package com.interview.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ThreadJoin -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/5/21 14:09 
 */
public class ThreadJoin {
	public static void main(String[] args) throws Exception {
		int thread = 3;
		CountDownLatch countDownLatch = new CountDownLatch(thread);
		for (int i = 0; i < thread; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
						System.out.println("thread finished");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					countDownLatch.countDown();
				}
			}).start();
		}

		countDownLatch.await();
		System.out.println("main method finished");

	}

	public static void join() throws Exception {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("thread 1 finish");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					System.out.println("thread 2 finish");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();

		thread2.start();

		thread1.join();

		thread2.join();

		System.out.println("main method finished");
	}
}
