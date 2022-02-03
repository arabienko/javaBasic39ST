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

/**
 * Class for sorting an array.
 * Merge sort. Divide the array into parts
 * until it is equal to one element.
 * Each element of the array is sorted.
 * Merging: we compare one element from the arrays
 * and write the smaller one into a new array,
 * take the next element from the array
 * and compare with the previous large one.
 */
public class SortMergeArray implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(SortMergeArray.class);

    private String nameThread;
    private Massive massive;
    private ReentrantLock lock;
    Phaser phaser;

    public SortMergeArray(Massive massive,
                          ReentrantLock lock,
                          String nameThread) {
        this.nameThread = nameThread;
        this.massive = massive;
        this.lock = lock;
        phaser = new Phaser();
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Massive call() throws Exception {
        LOGGER.debug("Start mergeSort- "
                + getNameThread());
        lock.lock();
        Massive resultMassive;
        Validation validation = new Validation();
        if (validation.checkIsEmptyMassive(massive)) {
            Number[] result = mergeSort(massive.getMassive());
            resultMassive = new Massive(result);
        } else {
            LOGGER.debug(
                    "Operation on massive is not possible!");
            throw new ServiceException(
                    "Operation on massive is not possible!");
        }
        LOGGER.debug("Method merge sort is completed. " +
                "Array: " + resultMassive);
        lock.unlock();
        return resultMassive;
    }

    private Number[] mergeSort(Number[] forSort) {
        Number[] left = new Number[forSort.length / 2];
        Number[] right =
                new Number[forSort.length - left.length];
        int center;
        if (forSort.length==1) {
            return forSort;
        } else {
            center = forSort.length / 2;
            // copy the left half of whole into the left.
            for (int i = 0; i < center; i++) {
                left[i] = forSort[i];
            }
            //copy the right half of whole into the new arraylist.
            int k = 0;
            for (int i = center; i < forSort.length; i++) {
                right[k] = forSort[i];
                k++;
            }
            // Sort the left and right halves of the arraylist.
            left = mergeSort(left);
            right = mergeSort(right);
            // Merge the results back together.
            merge(left, right, forSort);
        }
        return forSort;
    }

    private static void merge(Number[] left, Number[] right, Number[] forSort) {
        int leftIndex = 0;
        int rightIndex = 0;
        int wholeIndex = 0;
        // As long as neither the left nor the right ArrayList has
        // been used up, keep taking the smaller of left.get(leftIndex)
        // or right.get(rightIndex) and adding it at both.get(bothIndex).
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].doubleValue()
                    < (right[rightIndex]).doubleValue()) {
                forSort[wholeIndex] = left[leftIndex];
                leftIndex++;
            } else {
                forSort[wholeIndex] = right[rightIndex];
                rightIndex++;
            }
            wholeIndex++;
        }
        Number[] rest;
        int restIndex;
        if (leftIndex >= left.length) {
            // The left ArrayList has been use up...
            rest = right;
            restIndex = rightIndex;
        } else {
            // The right ArrayList has been used up...
            rest = left;
            restIndex = leftIndex;
        }
        // Copy the rest of whichever ArrayList (left or right) was not used up.
        for (int i = restIndex; i < rest.length; i++) {
            forSort[wholeIndex] = rest[i];
            wholeIndex++;
        }
    }
}
