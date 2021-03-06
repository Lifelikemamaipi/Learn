package tread;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：Good_M
 * @date ：Created in 2020 2020/3/2 20:37
 * 1、可以不阻塞子线程，调用完countdown以后子线程可继续往下执行
 * 2、不可复用
 *
 */
public class ThreadTest {

    public static void main(String[] args) {
        final int num = 5;
        final CountDownLatch begin = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(num);

        for (int i = 0; i < num; i++) {
            new Thread(new AWorker(i, begin, end)).start();
        }

        // judge prepare...
        try {
            Thread.sleep((long) (Math.random() * 5000));
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("judge say : run !");
        begin.countDown();
        long startTime = System.currentTimeMillis();

        try {
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("judge say : all arrived !");
            System.out.println("spend time: " + (endTime - startTime));
        }

    }

}

class AWorker implements Runnable {
    final CountDownLatch begin;
    final CountDownLatch end;
    final int id;

    public AWorker(final int id, final CountDownLatch begin,
                   final CountDownLatch end) {
        this.id = id;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.id + " ready !");
            begin.await();
            // run...
            Thread.sleep((long) (Math.random() * 10000));
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(this.id + " arrived !");
            end.countDown();
            System.out.println(this.id + " countDown end !");
        }
    }


}
