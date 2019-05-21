package com.interview.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title Volatile -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/5/17 17:27 
 */
public class Volatile implements Runnable {

	private static volatile boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			System.out.println(Thread.currentThread().getName() + " is running");
		}

		System.out.println(Thread.currentThread().getName() + " is stoped");
	}

	public static void main(String[] args) throws Exception {
		Volatile vo = new Volatile();
		Thread thread1 = new Thread(vo, "thread1");

		thread1.start();

		System.out.println("main thread is running.");
		TimeUnit.MILLISECONDS.sleep(100);

		vo.stopthread();
	}

	private void stopthread() {
		flag = false;
	}

}
