package by.arabienko.task05thread.service.threadImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class SumRows implements Callable<Number[]> {
    private static final Logger LOGGER =
            LogManager.getLogger(SumRows.class);
    private Number[] rowFirst;
    private Number[] rowSecond;
    private Phaser phaser;

    public SumRows(Number[] rowFirst,
                            Number[] rowSecond,
                            Phaser p) {
        this.rowFirst = rowFirst;
        this.rowSecond = rowSecond;
        this.phaser = p;
        phaser.register();
    }

    @Override
    public Number[] call() throws Exception {
        Number[] subRows = new Number[rowFirst.length];
        for (int i = 0; i < rowFirst.length; i++) {
            subRows[i] = rowFirst[i].doubleValue()
                    + rowSecond[i].doubleValue();
        }
        LOGGER.debug("Row was calculated. " +
                "Return in main thread " +
                "to continue calculations. ");
        return subRows;
    }
}
