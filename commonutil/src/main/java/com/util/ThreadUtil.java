package com.util;

import java.util.concurrent.*;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ThreadUtil -> Class
 * @Package CommonUtils -> com.util
 * @Description
 * @date 2019/1/10 13:54 
 */
public class ThreadUtil {
	private static ExecutorService executorService = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.SECONDS,
			new ArrayBlockingQueue<Runnable>(5));


	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					System.out.println(111);
					Thread.sleep(5000);
					System.out.println("2222");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();

		executorService.execute(new Runnable() {
			public void run() {
				try {
					System.out.println(333);
					Thread.sleep(5000);
					System.out.println("4444");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
