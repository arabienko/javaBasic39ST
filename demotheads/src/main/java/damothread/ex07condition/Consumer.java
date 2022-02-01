package damothread.ex07condition;

public class Consumer extends Thread {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 7; i++) {
            store.get();
        }
    }

}
