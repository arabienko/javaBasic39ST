package damothread.ex04consumer_producer;

public class Producer extends Thread {
    Store store;
    int product = 5;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product > 0) {
                product = product - store.put();
                System.out.println("производителю осталось произвести " + product + " товар(ов)");
                sleep(1000);
            }
        } catch(InterruptedException e){
            System.out.println("поток производителя прерван");
            }
        }
    }


