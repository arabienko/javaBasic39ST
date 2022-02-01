package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class SortSimpleArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortSimpleArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortSimpleArray(Massive massive,
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
        LOGGER.debug("Start SimpleSort- "
                + getNameThread());
        lock.lock();
        Validation validation = new Validation();
        int left = 0;
        int right = massive.getMassive().length;
        if (validation.
                checkIsEmptyMassive(massive)) {

            for (int i = left; i < right - 1; i++) {
                int min = i;

                for (int j = i + 1; j < right; j++) {
                    if (massive.getMassive()[j].doubleValue()
                            < massive.getMassive()[min].doubleValue()) {
                        min = j;
                    }
                }
                double changeValueMin =
                        massive.getMassive()[min].doubleValue();
                double changeValueMax =
                        massive.getMassive()[i].doubleValue();
                massive.setElement(i, changeValueMin);
                massive.setElement(min, changeValueMax);

            }
        } else {
            LOGGER.debug("Operation on massive " +
                    "(simple select) is not possible!");
            throw new ServiceException(
                    "Operation on massive is not possible!");
        }
        LOGGER.debug("Method simple sort is completed. " +
                "Array: "+massive);
        lock.unlock();
        return massive;    }
}
