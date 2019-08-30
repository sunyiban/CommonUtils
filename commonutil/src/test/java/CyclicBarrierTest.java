import java.io.ByteArrayInputStream;
import java.util.concurrent.CyclicBarrier;

/**
 * @autor sunyiban
 * @date 2019/8/30 9:35
 * @descrpition
 */
public class CyclicBarrierTest {

    static class TaskThread extends Thread {
        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(getName() + "到达栅栏 A");
                barrier.await();
                System.out.println(getName() + "冲破栅栏 A");

                Thread.sleep(4000);
                System.out.println(getName() + "到达栅栏 B");
                barrier.await();
                System.out.println(getName() + "冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            int threadNum = 5;
            CyclicBarrier barrier = new CyclicBarrier(threadNum, new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "完成最后任务");
                }
            });

            for (int i = 0; i < threadNum; i++) {
                new TaskThread(barrier).start();
            }
        }


    }

}
