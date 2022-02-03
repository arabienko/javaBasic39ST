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
 * Simple insertion method.
 * At each step of the algorithm we take
 * one of the array elements (starting from the first),
 * find the position for insertion from
 * the left part of the array and insert it.
 * An array of one element is considered sorted.
 */
public class SortInsertionArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortInsertionArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortInsertionArray(Massive massive,
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
        LOGGER.debug("Start InsertionSort- "
                + getNameThread());
        lock.lock();
        Validation validation = new Validation();
        if (validation.checkIsEmptyMassive(massive)) {
            for (int i =1; i
                    < massive.getMassive().length; i++) {
                double current =
                        massive.getMassive()[i].doubleValue();
                int j = i - 1;
                while (j >= 0 && current
                        < massive.getMassive()[j].doubleValue()) {
                    massive.setElement(j + 1,massive.getMassive()[j]);
                    j--;
                }
                massive.setElement(j + 1,current);
            }
        } else {
            LOGGER.debug(
                    "Operation on massive is not possible!");
            throw new ServiceException(
                    "Operation on massive is not possible!");
        }
        LOGGER.debug("Method insertion sort is completed. " +
                "Array: "+massive);
        lock.unlock();
        return massive;
    }
}
