package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SortMassiveService;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Simple choice method. The element
 * with the minimum value is selected
 * and exchanged with the first element.
 * Then, from the remaining n-1 elements,
 * the minimum is selected and exchanged
 * with the second, etc.
 */
public class SimpleSelectSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(SimpleSelectSortMassiveImpl.class);

    /**
     * @param massive for sort
     * @return sort massive (method simple select).
     * @throws ServiceException
     */
    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {

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
            LOGGER.debug("Operation on massive (simple select) is not possible!");
            throw new ServiceException("Operation on massive is not possible!");
        }

        LOGGER.debug("Method simple select is completed");
        return null;
    }
}
