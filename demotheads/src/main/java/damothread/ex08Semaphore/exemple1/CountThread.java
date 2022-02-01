package damothread.ex08Semaphore.exemple1;

import java.util.concurrent.Semaphore;

public class CountThread implements Runnable {
    CommonResource commonResource;
    String name;
    Semaphore semaphore;

    public CountThread(CommonResource commonResource,
                       Semaphore semaphore, String name) {
        this.commonResource = commonResource;
        this.name = name;
        this.semaphore = semaphore;
    }


    @Override
    public synchronized void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            semaphore.acquire();
            commonResource.x = 1;
            for (int i = 0; i < 2; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " освобождает разрешение");
        semaphore.release();
    }
}
