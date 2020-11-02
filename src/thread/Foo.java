package thread;

import java.util.concurrent.Semaphore;

/**
 * 按序打印
 * https://leetcode-cn.com/problems/print-in-order/
 *
 * @author liuxin
 * @time 2020/11/2 14:54
 */
public class Foo {

    private final Semaphore secSemaphore;
    private final Semaphore thiSemaphore;

    public Foo() {
        secSemaphore = new Semaphore(0);
        thiSemaphore = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        secSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        secSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        thiSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        thiSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
