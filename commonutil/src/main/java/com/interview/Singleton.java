package com.interview;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title Singleton -> Class
 * @Package CommonUtils -> com.interview
 * @Description 静态内部类实现单例模式
 * @date 2019/5/9 16:48 
 */
public class Singleton {

	static {
		System.out.println("this is out class");
	}

	private Singleton(){}

	public static Singleton getSingleton() {
		return SingletonInstance.INSTANCE;
	}

	private static class SingletonInstance{
		static {
			System.out.println("this is inner class");
		}
		// 因为是静态常量，所以只会加载一次
		private static final Singleton INSTANCE = new Singleton();

		static void test() {
			System.out.println("this is inner class test method");
		}
	}

	public static void main(String[] args) {
		Singleton singleton = new Singleton();
		System.out.println("==================================");
		// 静态内部类会在调用的时候才加载
		Singleton.SingletonInstance.test();
	}
}
