package damothread.ex19atomic;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicMain {
    private static final int NUMBER_BROKERS = 5;

    public static void main(String[] args) {
        Market market = new Market(new AtomicLong(100));
        Market marketLong = new Market(100L);
        Broker.initMarket(marketLong);
        market.start();
        for (int i = 0; i < NUMBER_BROKERS; i++) {
            new Broker().start();

        }
    }
}
