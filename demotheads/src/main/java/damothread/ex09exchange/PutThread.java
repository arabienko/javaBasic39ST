package damothread.ex09exchange;

import java.util.concurrent.Exchanger;

public class PutThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    public PutThread(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        message = "Hello world!!!";
    }

    @Override
    public void run() {
        try {
            message += " - It is the message from PutThread (" + Thread.currentThread().getName() + ")";
            message = exchanger.exchange(message);
            System.out.println("PutThread " + Thread.currentThread().getName() + " получил: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
