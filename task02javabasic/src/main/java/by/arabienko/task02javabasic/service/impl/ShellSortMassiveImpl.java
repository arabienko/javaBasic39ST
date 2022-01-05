package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SortMassiveService;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Shell sort. Elements that are
 * spaced apart from each other
 * at a certain STEP distance are sorted.
 * Then the sorting is repeated at lower
 * values of STEP (step / 2) and at the end
 * the sorting process ends with STEP = 1
 * (ordinary sorting by insertions).
 */
public class ShellSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ShellSortMassiveImpl.class);

    /**
     * @param massive sort massive method Shell.
     * @return sort massive.
     * @throws ServiceException
     */
    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {

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
            System.out.println(array);
            massive.setMassive(array);
        } else {
            LOGGER.debug("Operation on massive (Shell) is not possible!");
            throw new ServiceException("Operation on massive is not possible!");
        }

        LOGGER.debug("Sort Method is completed.");
        return massive;
    }
}
