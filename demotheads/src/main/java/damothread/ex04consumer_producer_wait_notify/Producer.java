package damothread.ex04consumer_producer_wait_notify;

public class Producer extends Thread {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            store.put();
        }
    }
}


