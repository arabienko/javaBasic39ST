package damothread.ex06ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadsApp {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        ReentrantLock locker  = new ReentrantLock();
        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(new CountThread(commonResource,locker));
            thread.start();
        }
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
