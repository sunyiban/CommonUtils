/**
 * @author sunyiban@panda-fintech.com
 * @title: SyncTest
 * @copyright: Copyright (c) 2018
 * @description: <br>
 * @company: panda-fintech
 * @created on 2020/7/2下午4:01
 */
public class SyncTest {

  public synchronized void getName() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("my name is sun");
  }

  public static void main(String[] args) {
    compare("3", 4.13);
  }

  public static void compare (Object a, Object b) {

    if (a instanceof Double) {

    }
  }
}
