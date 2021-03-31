import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：Good_M
 * @date ：Created in 2020 2020/3/2 20:38
 * 1、必定会阻塞子线程
 * 2、可复用
 *
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        final int count = 5;
        final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
            @Override
            public void run() {
                System.out.println("drink beer!");
            }
        });

        // they do not have to start at the same time...
        for (int i = 0; i < count; i++) {
            new Thread(new Worker(i, barrier)).start();
        }


    }

}

class Worker implements Runnable {
    final int id;
    final CyclicBarrier barrier;

    public Worker(final int id, final CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.id + "starts to run !");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println(this.id + "arrived !");
            this.barrier.await();
            System.out.println("await end"+this.id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

