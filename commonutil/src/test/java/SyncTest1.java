/**
 * @author sunyiban@panda-fintech.com
 * @title: SyncTest1
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/2下午4:02
 */
public class SyncTest1 {

  public static void main(String[] args) {
    SyncTest syncTest = new SyncTest();
    SyncTest syncTest1 = new SyncTest();

    A a = new A(syncTest);
    A b = new A(syncTest1);
    Thread t1 = new Thread(a);
    Thread t2 = new Thread(b);


    t1.start();

    t2.start();
  }

  static class A implements Runnable {

    SyncTest syncTest;

    public A(SyncTest syncTest) {
      this.syncTest = syncTest;
    }

    @Override
    public void run() {
     syncTest.getName();
    }
  }
}
