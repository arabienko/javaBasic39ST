package damothread.ex08Semaphore.exemple2;

import java.util.concurrent.Semaphore;

public class PhilosophersApp {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 2; i++) {
            new Philosopher(semaphore,i).start();
        }

    }
}
