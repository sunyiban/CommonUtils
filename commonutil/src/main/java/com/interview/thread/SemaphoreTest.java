package com.interview.thread;

import java.util.concurrent.Semaphore;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title SemaphoreTest -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/6/11 15:36 
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		// 五台电脑
		Semaphore semaphore = new Semaphore(5);

		// 十个人
		int person = 10;

		for(int i = 0; i < person; i++) {
			new Thread(new Worker(i, semaphore)).start();
		}
	}

	private static class Worker implements Runnable {
		private int i;
		private Semaphore semaphore;

		public Worker(int i, Semaphore semaphore) {
			this.i = i;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("work" + i + "start to play.");
				Thread.sleep(2000);
				System.out.println("work" + i + "finish use!");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
