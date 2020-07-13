package com.interview.thread;

/**
 * @author sunyiban@panda-fintech.com
 * @title: ThreadAndObject
 * @copyright: Copyright (c) 2018
 * @description: 测试多线程调用同一对象<br>
 * @company: panda-fintech
 * @created on 2019/11/22上午10:25
 */
public class ThreadAndObject {
  public static void main(String[] args) {
    // 同一个对象在多线程传递时，如果不加控制，可能会产生数据错乱
    A a = new ThreadAndObject().new A();
    a.setA("123");
    a.setB(11);

    // 第一个线程进入后修改了a的属性值
    new Thread(new ThreadAndObject().new B(a)).start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 第二个线程读取时a中的属性已被修改
    new Thread(new ThreadAndObject().new B(a)).start();



  }

  public class A {
    private String a;
    private int b;

    public String getA() {
      return a;
    }

    public void setA(String a) {
      this.a = a;
    }

    public int getB() {
      return b;
    }

    public void setB(int b) {
      this.b = b;
    }

    @Override
    public String toString() {
      return "A{" +
              "a='" + a + '\'' +
              ", b=" + b +
              '}';
    }
  }

  public class B implements Runnable {
    private A a;

    B(A a) {
      this.a = a;
    }


    @Override
    public void run() {
      System.out.println("first read" + a.toString());
      a.setA("345");
      a.setB(33);
    }

  }
}
