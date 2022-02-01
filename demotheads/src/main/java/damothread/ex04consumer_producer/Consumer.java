package damothread.ex04consumer_producer;

public class Consumer extends Thread {
    Store store;
    int product = 0;
    final int max = 5;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product < max) {
                product = product + store.get();
                System.out.println("Потребитель купил " + product + " товар(ов)");

                sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("поток потребителя прерван");        }
    }
}
