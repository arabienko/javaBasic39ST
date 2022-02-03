package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class for sorting an array.
 * The exchange sort is similar to its cousin, the bubble sort.
 * Bubble method. Sequential comparison and exchange
 * of adjacent elements, if the previous one is larger
 * than the next one (light elements slowly emerge).
 */
public class SortExchangeArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortExchangeArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortExchangeArray(Massive massive,
                          ReentrantLock lock,
                             String nameThread) {
        this.nameThread = nameThread;
        this.massive = massive;
        this.lock = lock;
    }
    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Massive call() throws Exception {
        LOGGER.debug("Start ExchangeSort- "
                + getNameThread());
        lock.lock();
        int count;
        Validation validation = new Validation();
        if (validation.checkIsEmptyMassive(massive)) {
            do {
                count = 0;
                for (int i = 0; i
                        < massive.getMassive().length - 1; i++) {
                    if (massive.getMassive()[i + 1].doubleValue()
                            < massive.getMassive()[i].doubleValue()) {
                        double changeValueMin =
                                massive.getMassive()[i + 1].doubleValue();
                        double changeValueMax =
                                massive.getMassive()[i].doubleValue();
                        massive.setElement(i, changeValueMin);
                        massive.setElement(i + 1, changeValueMax);
                        count++;
                    }
                }
            } while (count!=0);
        } else {
            LOGGER.error(" Massive is empty.");
            throw new ServiceException(
                    "Operation on massive is not possible!");
        }
        LOGGER.debug(
                "Exchange sort massive." + massive);
        lock.unlock();
        return massive;    }
}
