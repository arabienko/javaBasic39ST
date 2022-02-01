package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;
import java.util.concurrent.locks.ReentrantLock;

public class SortMergeArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortMergeArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;

    public SortMergeArray(Massive massive,
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
        Validation validation = new Validation();

        //massive for changing.
        Number[] tmp;
        //Massive for sorting.
        Number[] array = massive.getMassive();
        //Copy array.
        Number[] currentArray = array;
        //Array with the same size.
        Number[] currentTempArray = new Number[massive.getMassive().length];
        Phaser phaser = new Phaser();
        if (validation.checkIsEmptyMassive(massive)) {
            int size = 1;
            while (size < array.length) {
                for (int i = 0; i < array.length; i += 2 * size) {
                    int indStartFirst = i;
                    int indStartSecond = i + size;
                    int finalSize = size;
                    Number[] arrayFirst = currentArray;
                    Number[] arraySecond = currentArray;
                    Number[] destArray = currentTempArray;
                    int destIndStart = i;
                    new Thread(() -> {
                        SortMergeArray sortMergeArray = null;
                        LOGGER.debug("start merge "+Thread.currentThread());
                        Phaser phaser1 = phaser;
                        phaser1.register();
                        int indexStartFirst = indStartFirst;
                        int indexStartSecond = indStartSecond;

                        //Calculate the end index of the subarray.
                        int srcEndFirst = Math.min(indStartFirst + finalSize, arrayFirst.length);
                        int srcEndSecond = Math.min(indStartSecond + finalSize, arraySecond.length);

                        if (indStartFirst + finalSize > arrayFirst.length) {
                            for (int j = indStartFirst; j < srcEndFirst; j++) {
                                sortMergeArray.massive.getMassive()[j] = arrayFirst[j];
                            }
                            return;
                        }
                        //The number of loop iterations.
                        int iterationCount = srcEndFirst - indStartFirst + srcEndSecond - indStartSecond;

                        //Loop merging two arrays, comparing their elements and adding them to the resulting array.
                        for (int j = destIndStart; j < destIndStart + iterationCount; j++) {
                            if (indexStartFirst < srcEndFirst && (indexStartSecond >= srcEndSecond ||
                                    arrayFirst[indexStartFirst].doubleValue() <
                                            arraySecond[indexStartSecond].doubleValue())) {

                                sortMergeArray.massive.getMassive()[j] = arrayFirst[indexStartFirst];
                                indexStartFirst++;

                            } else {

                                destArray[j] = arraySecond[indexStartSecond];
                                indexStartSecond++;
                            }
                        }
                        phaser1.arriveAndAwaitAdvance();
                    }).start();
                    // merge(currentArray, i, currentArray, i + size, currentTempArray, i, size);
                }
                tmp = currentArray;
                currentArray = currentTempArray;
                currentTempArray = tmp;

                size = size * 2;

            }
            massive.setMassive(currentArray);
        } else {
            LOGGER.debug("You cannot sort by merge.");
            throw new ServiceException("Operation on massive is not possible!");
        }
        phaser.arriveAndDeregister();
        return massive;
    }
}
