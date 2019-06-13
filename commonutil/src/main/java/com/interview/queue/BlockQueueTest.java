package com.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title BlockQueueTest -> Class
 * @Package CommonUtils -> com.interview.queue
 * @Description
 * @date 2019/6/11 16:09 
 */
public class BlockQueueTest {
	private static BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

	private static class Produce implements Runnable {
		@Override
		public void run() {
			try {
				blockingQueue.put("product");
				System.out.println("produce a product");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class Consumer implements Runnable {
		@Override
		public void run() {
			try {
				blockingQueue.take();
				System.out.println("take a product");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Produce()).start();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(new Consumer()).start();
		}

		for (int i = 0; i < 5; i++) {
			new Thread(new Produce()).start();
		}


	}
}
