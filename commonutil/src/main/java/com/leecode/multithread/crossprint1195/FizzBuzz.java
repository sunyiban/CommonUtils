package com.leecode.multithread.crossprint1195;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author sunyiban@panda-fintech.com
 * @title: FizzBuzz
 * @copyright: Copyright (c) 2018
 * @description:
 *
 * 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 *
 *   1  线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。
 *   2  线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。
 *   3  线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。
 *   4  线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * @company: panda-fintech
 * @created on 2020/1/3下午2:39
 */
public class FizzBuzz {
  private int n;
  Semaphore number = new Semaphore(1);
  Semaphore fizz = new Semaphore(0);
  Semaphore buzz = new Semaphore(0);
  Semaphore fizzBuzz = new Semaphore(0);

  private int i = 1;
  public FizzBuzz(int n) {
    this.n = n;
  }

  // printFizz.run() outputs "fizz".
  public void fizz(Runnable printFizz) throws InterruptedException {
    while (true) {
      fizz.acquire();
      if (i > n) {
        return;
      }
      printFizz.run();;
      i++;
      number.release();
    }
  }

  // printBuzz.run() outputs "buzz".
  public void buzz(Runnable printBuzz) throws InterruptedException {
    while (true) {
      buzz.acquire();
      if (i > n) {
        return;
      }
      printBuzz.run();
      i++;
      number.release();
    }
  }

  // printFizzBuzz.run() outputs "fizzbuzz".
  public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    while (true) {
      fizzBuzz.acquire();
      if (i > n) {
        return;
      }
      printFizzBuzz.run();
      i++;
      number.release();
    }
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void number(IntConsumer printNumber) throws InterruptedException {
    while (i <= n) {
      number.acquire();
      if (i % 3 == 0 && i % 5 == 0) {
        fizzBuzz.release();
      } else if (i % 3 == 0) {
        fizz.release();
      } else if (i % 5 == 0) {
        buzz.release();
      } else {
        printNumber.accept(i);
        i++;
        number.release();
      }
    }

    fizz.release();
    buzz.release();
    fizzBuzz.release();
  }


}
