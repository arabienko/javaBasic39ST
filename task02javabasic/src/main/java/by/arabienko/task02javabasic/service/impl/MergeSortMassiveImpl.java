package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SortMassiveService;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Merge sort. Divide the array into parts
 * until it is equal to one element.
 * Each element of the array is sorted.
 * Merging: we compare one element from the arrays
 * and write the smaller one into a new array,
 * take the next element from the array
 * and compare with the previous large one.
 */
public class MergeSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(MergeSortMassiveImpl.class);

    /**
     * @param massive massive for sort.
     * @return new
     * @throws ServiceException
     */
    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {


        Validation validation = new Validation();

        //massive for changing.
        Number[] tmp;
        //Massive for sorting.
        Number[] array = massive.getMassive();
        //Copy array.
        Number[] currentArray = array;
        //Array with the same size.
        Number[] currentTempArray = new Number[massive.getMassive().length];

        if (validation.checkIsEmptyMassive(massive)) {
            int size = 1;
            while (size < array.length) {
                for (int i = 0; i < array.length; i += 2 * size) {
                    merge(currentArray, i, currentArray, i + size, currentTempArray, i, size);
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
        return massive;
    }

    /**
     * @param arrayFirst     First massive for merge.
     * @param indStartFirst  Start merge index.
     * @param arraySecond    Second massive for merge.
     * @param indStartSecond Start merge index.
     * @param destArray      The destination of the merge arrays.
     * @param destIndStart   The starting index to add the array.
     * @param size           Size subarray for merge.
     */
    private static void merge(Number[] arrayFirst, int indStartFirst, Number[] arraySecond,
                              int indStartSecond, Number[] destArray,
                              int destIndStart, int size) {
        int indexStartFirst = indStartFirst;
        int indexStartSecond = indStartSecond;

        //Calculate the end index of the subarray.
        int srcEndFirst = Math.min(indStartFirst + size, arrayFirst.length);
        int srcEndSecond = Math.min(indStartSecond + size, arraySecond.length);

        if (indStartFirst + size > arrayFirst.length) {
            for (int i = indStartFirst; i < srcEndFirst; i++) {
                destArray[i] = arrayFirst[i];
            }
            return;
        }
        //The number of loop iterations.
        int iterationCount = srcEndFirst - indStartFirst + srcEndSecond - indStartSecond;

        //Loop merging two arrays, comparing their elements and adding them to the resulting array.
        for (int i = destIndStart; i < destIndStart + iterationCount; i++) {
            if (indexStartFirst < srcEndFirst && (indexStartSecond >= srcEndSecond ||
                    arrayFirst[indexStartFirst].doubleValue() <
                            arraySecond[indexStartSecond].doubleValue())) {

                destArray[i] = arrayFirst[indexStartFirst];
                indexStartFirst++;

            } else {

                destArray[i] = arraySecond[indexStartSecond];
                indexStartSecond++;
            }
        }
    }

}
