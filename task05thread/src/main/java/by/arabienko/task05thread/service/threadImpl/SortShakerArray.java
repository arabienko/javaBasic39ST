package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class SortShakerArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortShakerArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortShakerArray(Massive massive,
                           ReentrantLock lock,String nameThread) {
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
        lock.lock();
        int lastChangeIndexRight = 0;
        int left = 0;
        int right = massive.getMassive().length - 1;
        Validation validation = new Validation();

        if (validation.checkIsEmptyMassive(massive)) {
            do {
                for (int i = left; i < right; i++) {
                    if (massive.getMassive()[i + 1].doubleValue() <
                            massive.getMassive()[i].doubleValue()) {
                        double changeValueMin = massive.getMassive()[i + 1].doubleValue();
                        double changeValueMax = massive.getMassive()[i].doubleValue();
                        massive.setElement(i, changeValueMin);
                        massive.setElement(i + 1, changeValueMax);
                        //TODO: last index
                        lastChangeIndexRight = i;
                    }
                }
                right = lastChangeIndexRight;
                for (int i = right; i > left; i--) {
                    if (massive.getMassive()[i].doubleValue() <
                            massive.getMassive()[i - 1].doubleValue()) {
                        double changeValueMin = massive.getMassive()[i].doubleValue();
                        double changeValueMax = massive.getMassive()[i - 1].doubleValue();
                        massive.setElement(i - 1, changeValueMin);
                        massive.setElement(i, changeValueMax);
                    }
                }
                left++;
            } while (left < right);
        } else {
            LOGGER.debug("Operation on massive (Shaker) is not possible!");
            throw new ServiceException("Operation on massive is not possible!");
        }
        LOGGER.debug(" Method shaker completed. "+massive);
        lock.unlock();
        return massive;
    }
}
