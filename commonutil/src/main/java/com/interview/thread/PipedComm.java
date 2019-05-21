package com.interview.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title PipedComm -> Class
 * @Package CommonUtils -> com.interview.thread
 * @Description
 * @date 2019/5/21 14:54 
 */
public class PipedComm {

	public static void main(String[] args) throws Exception {
		PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream = new PipedOutputStream();

		pipedInputStream.connect(pipedOutputStream);

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						pipedOutputStream.write(i);
						Thread.sleep(500);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						pipedOutputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					int msg = 0;
					while ((msg = pipedInputStream.read()) != -1) {
						System.out.println("this is reader:" + msg);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						pipedInputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();


	}

}
