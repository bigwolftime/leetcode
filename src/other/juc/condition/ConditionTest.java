package other.juc.condition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用 condition 实现阻塞队列
 * @author liuxin
 * @date 2022/5/13 9:25 PM
 */
public class ConditionTest {

    public static void main(String[] args) {
        MyBlockQueue myBlockQueue = new MyBlockQueue(2);

        new Thread(() -> {
            Random random = new Random();

            for (int i = 0; i < 20; i++) {
                try {
                    myBlockQueue.put(i);
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }).start();

        new Thread(() -> {
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                try {
                    myBlockQueue.take();
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }


    public static class MyBlockQueue {

        private final Lock lock = new ReentrantLock();

        private final List<Integer> data = new ArrayList<>();

        private final int length;


        private final Condition putCondition = lock.newCondition();
        private final Condition takeCondition = lock.newCondition();


        public MyBlockQueue(int length) {
            this.length = length;
        }

        public void put(Integer s) throws InterruptedException {
            lock.lock();
            try {
                if (data.size() >= length) {
                    putCondition.await();
                }

                data.add(s);
                System.err.println("put" + s);
                takeCondition.signal();
            } finally {
                lock.unlock();
            }

        }

        public Integer take() throws InterruptedException {
            lock.lock();

            try {

                if (data.size() <= 0) {
                    takeCondition.await();
                }

                Integer s = data.remove(0);
                System.err.println("take" +s);
                putCondition.signal();
                return s;
            } finally {
                lock.unlock();
            }
        }

    }


}

