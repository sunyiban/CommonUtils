package com.interview.thread;


/**
 * @author sunyiban
 * @version V 1.0
 * @Title ThreadCross -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/5/17 16:14 
 */
public class ThreadCross {

	private int count = 0;

	public static void main(String[] args) {
//		ThreadCross threadCross = new ThreadCross();
//
//		Thread thread1 = new Thread(new PrintOddNumber(threadCross));
//		Thread thread2 = new Thread(new PrintEvenNumber(threadCross));
//
//		thread1.start();
//		thread2.start();

		join();

	}

	public static void join() {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("this is thread 1");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});


		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("this is thread 2");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("this is main thread");

	}


	static class PrintOddNumber implements Runnable{

		private ThreadCross count;

		PrintOddNumber(ThreadCross num) {
			this.count = num;
		}

		@Override
		public void run() {
			synchronized (ThreadCross.class) {
				while(true) {
					if (count.count < 100 && count.count % 2 != 0) {
						System.out.println("this is print odd number:" + count.count);
						count.count++;
						ThreadCross.class.notify();
					} else {
						try {
							ThreadCross.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	static class PrintEvenNumber implements Runnable{

		private ThreadCross count;

		PrintEvenNumber(ThreadCross num) {
			this.count = num;
		}

		@Override
		public void run() {
			synchronized (ThreadCross.class) {
				while (true) {
					if (count.count < 100 && count.count % 2 == 0) {
						System.out.println("this is print even number:" + count.count);
						count.count++;
						ThreadCross.class.notify();
					} else {
						try {
							ThreadCross.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}
