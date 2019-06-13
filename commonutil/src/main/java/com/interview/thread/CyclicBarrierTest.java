package com.interview.thread;

import java.util.concurrent.*;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title CyclicBarrierTest -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/6/11 15:47 
 */
public class CyclicBarrierTest {
	public static void main(String[] args) throws Exception {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			executorService.execute(() -> {
				try {
					System.out.println("people start");
					cyclicBarrier.await(1, TimeUnit.SECONDS);
					System.out.println("people end!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
}
