package com.interview.thread;

import java.util.concurrent.*;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ThreadPoolTest -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/6/13 10:39 
 */
public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {
		System.out.println(System.currentTimeMillis());
		scheduledThreadPool();

		fixedThreadPoll();


	}

	// 这是一个延时执行的线程测试
	public static void scheduledThreadPool() throws Exception {
		ExecutorService executorService = Executors.newScheduledThreadPool(3);
		((ScheduledExecutorService) executorService).schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("五秒延时打印");
				System.out.println(System.currentTimeMillis());
			}
		}, 5, TimeUnit.SECONDS);
		executorService.shutdown();
	}

	// 这是一个带有返回值，异常信息的线程测试
	public static void fixedThreadPoll() throws Exception {

		ExecutorService executorService = Executors.newFixedThreadPool(2, (runnable) -> {
			Thread thread = new Thread(runnable);
			thread.setName("线程1");
			return thread;});

		try {
			Future future = executorService.submit(new A());
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}


	static class A implements Callable {
		@Override
		public Object call() throws Exception {
			return new ArithmeticException("这是一个抛出的异常，名为："+ Thread.currentThread().getName());
		}
	}

}
