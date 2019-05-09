package com.interview;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title SingletonWithDoubleCheck -> Class
 * @Package CommonUtils -> com.interview
 * @Description 双检查懒汉单利模式
 * @date 2019/5/9 16:58 
 */
public class SingletonWithDoubleCheck {
	private SingletonWithDoubleCheck(){}

	private static volatile SingletonWithDoubleCheck singletonWithDoubleCheck;

	public synchronized SingletonWithDoubleCheck getInstatnce(){
		if (singletonWithDoubleCheck == null) {
			synchronized (SingletonWithDoubleCheck.class) {
				if (singletonWithDoubleCheck == null) {
					singletonWithDoubleCheck = new SingletonWithDoubleCheck();
				}
			}
		}
		return singletonWithDoubleCheck;
	}
}
