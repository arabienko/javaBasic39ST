package damothread.ex06ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    CommonResource commonResource;
    ReentrantLock locker;

    public CountThread(CommonResource commonResource,
                       ReentrantLock locker) {
        this.commonResource = commonResource;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        try {
            commonResource.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;


                Thread.sleep(100);
            }
        } catch (InterruptedException e) {

        }finally {
            locker.unlock();
        }
    }
}
