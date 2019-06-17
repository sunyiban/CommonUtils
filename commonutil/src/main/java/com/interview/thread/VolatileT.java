package com.interview.thread;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title VolatileT -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/5/27 9:25 
 */
public class VolatileT {
	private volatile int inc = 0;

	private synchronized void increase() {
		System.out.println(inc);
		inc++;
	}



	public static void main(String[] args) {

	}

}
