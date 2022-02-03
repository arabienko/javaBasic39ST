package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.SortMassiveService;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Simple insertion method.
 * At each step of the algorithm we take
 * one of the array elements (starting from the first),
 * find the position for insertion from
 * the left part of the array and insert it.
 * An array of one element is considered sorted.
 */
public class InsertionSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(InsertionSortMassiveImpl.class);

    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {

        Validation validation = new Validation();

        if (validation.checkIsEmptyMassive(massive)) {

            for (int i = 1; i < massive.getMassive().length; i++) {
                double current = massive.getMassive()[i].doubleValue();
                int j = i - 1;
                while (j >= 0 && current < massive.getMassive()[j].doubleValue()) {
                    massive.setElement(j + 1,massive.getMassive()[j]);
                    j--;
                }
                massive.setElement(j + 1,current);
            }
        } else {
            LOGGER.debug("Operation on massive is not possible!");
            throw new ServiceException("Operation on massive is not possible!");
        }
        return massive;
    }
}
