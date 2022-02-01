package damothread.ex04consumer_producer_wait_notify;

public class Consumer extends Thread {
    Store store;
    int product = 0;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            store.get();
        }
    }
}
