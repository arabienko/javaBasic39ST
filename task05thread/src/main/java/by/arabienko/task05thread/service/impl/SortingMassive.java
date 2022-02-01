package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;

/**
 * service for sorting an array.
 */
public class SortingMassive {

    public void exchangeSortMassive(Massive<Number> massive) throws ServiceException {
        int count;
        Validation validation = new Validation();

        if (validation.checkIsEmptyMassive(massive)) {
            do {
                count = 0;
                for (int i = 0; i < massive.getMassive().length - 1; i++) {
                    if (massive.getMassive()[i + 1].doubleValue() <
                            massive.getMassive()[i].doubleValue()) {
                        double changeValueMin = massive.getMassive()[i + 1].doubleValue();
                        double changeValueMax = massive.getMassive()[i].doubleValue();
                        massive.setElement(i, changeValueMin);
                        massive.setElement(i + 1, changeValueMax);
                        count++;
                    }
                }
            } while (count!=0);
        } else {
            throw new ServiceException("Operation on massive is not possible!");
        }
    }

    public void shakerSortMassive(Massive massive) throws ServiceException {

        int lastChangeIndex = 0;
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
                        lastChangeIndex = i;
                    }
                }
                right = lastChangeIndex;
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
            //LOGGER.debug();
            throw new ServiceException("Operation on massive is not possible!");
        }
    }

    public void simpleSelectSortMassive(Massive<Number> massive) throws ServiceException {

        Validation validation = new Validation();
        int left = 0;
        int right = massive.getMassive().length;

        if (validation.checkIsEmptyMassive(massive)) {

            for (int i = left; i < right - 1; i++) {
                int min = i;

                for (int j = i + 1; j < right; j++) {
                    if (massive.getMassive()[j].doubleValue() <
                            massive.getMassive()[min].doubleValue()) {
                        min = j;
                    }
                }
                double changeValueMin = massive.getMassive()[min].doubleValue();
                double changeValueMax = massive.getMassive()[i].doubleValue();
                massive.setElement(i, changeValueMin);
                massive.setElement(min, changeValueMax);

            }
        } else {
            throw new ServiceException("Operation on massive is not possible!");
        }
    }

    public void insertionSortMassive(Massive massive) throws ServiceException {
        Validation validation = new Validation();

        if (validation.checkIsEmptyMassive(massive)) {

            for (int i = 1; i < massive.getMassive().length; i++) {
                double current = massive.getMassive()[i].doubleValue();
                int j = i - 1;
                while (j >= 0 && current < massive.getMassive()[j].doubleValue()) {
                    massive.getMassive()[j + 1] = massive.getMassive()[j];
                    j--;
                }
                massive.getMassive()[j + 1] = current;
            }
        } else {
            throw new ServiceException("Operation on massive is not possible!");
        }
    }


    /**
     * @param massive for sorting.
     */
    public void mergeSortMassive(Massive<Number> massive) throws ServiceException {

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
            throw new ServiceException("Operation on massive is not possible!");
        }
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

    /**
     * Shell method.
     *
     * @param massive for sorting.
     */
    public void shellSortMassive(Massive massive) {
        Number[] array = massive.getMassive();

        // Check interval.
        int gap = array.length / 2;

        // While interval between elements exist.
        while (gap >= 1) {
            for (int i = 0; i < array.length; i++) {

                // Move the right pointer until we can find such
                // that there is no necessary gap
                // between it and the element before it
                for (int c = i - gap; c >= 0; c -= gap) {

                    if (array[c].doubleValue() > array[c + gap].doubleValue()) {
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
    }
}
