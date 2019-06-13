package com.interview.thread;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title PrintEvenAndOddNumber -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description 交替打印奇偶数
 * @date 2019/5/29 10:25 
 */
public class PrintEvenAndOddNumber {

	private int start = 0;

	private boolean flag = false;

	public static void main(String[] args) {
		PrintEvenAndOddNumber printEvenAndOddNumber = new PrintEvenAndOddNumber();

		Thread thread1 = new Thread(new Even(printEvenAndOddNumber));
		Thread thread2 = new Thread(new  Odd(printEvenAndOddNumber));

		thread1.start();
		thread2.start();

	}


	static class Even implements Runnable {

		private PrintEvenAndOddNumber number;

		Even(PrintEvenAndOddNumber number) {
			this.number = number;
		}

		@Override
		public void run() {
			try {
				synchronized (number) {
					while(number.start < 100) {
						if (number.flag) {
							System.out.println("even print: " + number.start++);
							number.flag = false;
							number.notify();
						} else {
							number.wait();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Odd implements Runnable {
		private PrintEvenAndOddNumber number;

		Odd(PrintEvenAndOddNumber number) {
			this.number = number;
		}

		@Override
		public void run() {
			try {
				synchronized (number) {
					while(number.start < 100) {
						if (!number.flag) {
							System.out.println("odd print: " + number.start++);
							number.flag = true;
							number.notify();
						} else {
							number.wait();
						}
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
