package damothread.ex04consumer_producer;

public class Store {
    int count = 0;
    final int max = 5;

    public synchronized int put(){
        if (count < max){
            System.out.println("произвели 1 товар...");
            count++;
            System.out.println ("склад имеет " + count + " товар(ов)");
            return 1;
        }
        return 0;
    }

    public synchronized int get(){
        if (count > 0){
            System.out.println("забрали 1 товар ....");
            count--;
            System.out.println ("склад имеет " + count + " товар(ов)");
            return 1;
        }
        return 0;
    }
}
