import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title ThreadTest -> Class
 * @Package CommonUtils -> PACKAGE_NAME
 * @Description
 * @date 2019/6/14 15:02 
 */
public class ThreadTest {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(10);

		for (int i = 0; i < 20; i++) {
			new Thread(new Consumer(semaphore)).start();
		}

		Thread thread = new Thread(new Consumer(semaphore));
		Thread.holdsLock(thread);
	}

	static class Consumer implements Runnable {

		private Semaphore semaphore;

		Consumer(Semaphore semaphore) {
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("我好了");
				Thread.sleep(5000);
				semaphore.release();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
