package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.SortMassiveService;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Shaker sorting. Process the array
 * from left to right, moving the larger element
 * to the end of the array, and then from right
 * to left, the smaller element to the beginning of the array.
 */
public class ShakerSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ShakerSortMassiveImpl.class);


    /**
     * @param massive for sort
     * @return new sort massive
     * @throws ServiceException
     */
    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {
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
        LOGGER.debug(" Method shaker completed.");
        return massive;
    }
}
