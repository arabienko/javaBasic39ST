package by.arabienko.task05thread.service.threadImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class SubstractionRows implements Callable<Number[]> {
    private static final Logger LOGGER =
            LogManager.getLogger(SubstractionRows.class);
    private Number[] rowFirst;
    private Number[] rowSecond;
    private CyclicBarrier barrier;

    public SubstractionRows(Number[] rowFirst,
                            Number[] rowSecond,
                            CyclicBarrier barrier) {
        this.rowFirst = rowFirst;
        this.rowSecond = rowSecond;
        this.barrier = barrier;
    }

    public CyclicBarrier getBarrier() {
        return barrier;
    }

    @Override
    public Number[] call() throws Exception {
        Number[] subRows = new Number[rowFirst.length];
        for (int i = 0; i < rowFirst.length; i++) {
            subRows[i] = rowFirst[i].doubleValue() - rowSecond[i].doubleValue();
        }
        this.barrier.await();
        return subRows;
    }
}
