package by.arabienko.task05thread.service.threadImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Phaser;

public class MultiplyRows implements Callable<Number[]> {
    private static final Logger LOGGER =
            LogManager.getLogger(MultiplyRows.class);
    private Number[] rowFirst;
    private Number[] rowSecond;
    private CountDownLatch latch;

    public MultiplyRows(Number[] rowFirst,
                   Number[] rowSecond,
                   CountDownLatch l) {
        this.rowFirst = rowFirst;
        this.rowSecond = rowSecond;
        this.latch = l;
    }
    @Override
    public Number[] call() throws Exception {
        Number[] subRows = new Number[rowFirst.length];
        for (int i = 0; i < rowFirst.length; i++) {
            subRows[i] = rowFirst[i].doubleValue()
                    * rowSecond[i].doubleValue();
        }
        LOGGER.debug("Row was calculated. " +
                "Return in main thread " +
                "to continue calculations. ");
        latch.countDown();
        return subRows;    }
}
