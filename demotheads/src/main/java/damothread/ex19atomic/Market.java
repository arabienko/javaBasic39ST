package damothread.ex19atomic;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Market extends Thread {
    private AtomicLong index;
    private Long indexLong;
    private Random random = new Random();

    public Market(AtomicLong index) {
        this.index = index;
    }

    public Market(Long indexLong) {
        this.indexLong = indexLong;
    }


    public AtomicLong getIndex() {
        return index;
    }

    public Long getIndexLong() {
        return indexLong;
    }


    @Override
    public void run() {
        try {
        while (true) {
            index.addAndGet(random.nextInt(21) - 10);

                Thread.sleep(random.nextInt(500));
            }
        }catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
