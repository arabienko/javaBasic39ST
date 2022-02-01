package damothread.ex18ArrayBlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueMain {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(5);
        new Thread(() -> {
            for (int i = 0; i < 7; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    arrayBlockingQueue.put("java " + i);
                    System.out.println("Element " + i + " added");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(() -> {
            try {
                System.out.println("Element <" + arrayBlockingQueue.take() + "> took");
                System.out.println("Element <" + arrayBlockingQueue.take() + "> took");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
