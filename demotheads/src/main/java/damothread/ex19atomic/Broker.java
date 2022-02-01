package damothread.ex19atomic;

import java.util.concurrent.TimeUnit;

public class Broker extends Thread {
    private static Market market;
    private static final int PAUSE_IN_MILLIS = 5000;

    public static void initMarket(Market market) {
        Broker.market = market;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Current index: " + market.getIndex());

                TimeUnit.MILLISECONDS.sleep(PAUSE_IN_MILLIS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
