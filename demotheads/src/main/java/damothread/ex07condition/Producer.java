package damothread.ex07condition;

public class Producer extends Thread {
    Store store;
    int product = 5;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 0; i < 7; i++) {
            store.put();
        }
    }
}


