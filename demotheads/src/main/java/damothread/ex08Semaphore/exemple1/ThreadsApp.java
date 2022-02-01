package damothread.ex08Semaphore.exemple1;

import java.util.concurrent.Semaphore;

public class ThreadsApp {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        Semaphore semaphore = new Semaphore(1);//one permission
        new Thread(new CountThread(commonResource, semaphore, "CountThread 1")).start();
        new Thread(new CountThread(commonResource, semaphore, "CountThread 2")).start();
        new Thread(new CountThread(commonResource, semaphore, "CountThread 3")).start();

        /*for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CountThread(commonResource));
            thread.setName("Thread "+i);
            thread.start();
        }*/

      /*  for (int i = 0; i < 6; i++) {
            Thread thread2 = new Thread(new CountThread2(commonResource));
            thread2.setName("Thread "+i);
            thread2.start();
        }*/

    }
}
