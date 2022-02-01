package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class SortShellArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortShellArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortShellArray(Massive massive,
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
        LOGGER.debug("Start ShellSort- "
                + getNameThread());
        lock.lock();
        Number[] array = massive.getMassive();
        Validation validation = new Validation();
        if (validation.checkIsEmptyMassive(massive)) {
            // Check interval.
            int gap = array.length / 2;
            // While interval between elements exist.
            while (gap >= 1) {
                for (int i = 0; i < array.length; i++) {
                    // Move the right pointer until we can find such
                    // that there is no necessary gap
                    // between it and the element before it
                    for (int c = i - gap; c >= 0; c -= gap) {
                        if (array[c].doubleValue()
                                > array[c + gap].doubleValue()) {
                            double tmp = array[c + gap].doubleValue();
                            array[c + gap] = array[c];
                            array[c] = tmp;
                        }
                    }
                }
                // Recalculating the gap.
                gap = gap / 2;
            }
            massive.setMassive(array);
        } else {
            LOGGER.debug("Operation on massive " +
                    "(Shell) is not possible!");
            throw new ServiceException(
                    "Operation on massive is not possible!");
        }
        LOGGER.debug("Sort Method " +
                "is completed. "+massive);
        lock.unlock();
        return massive;    }
}
