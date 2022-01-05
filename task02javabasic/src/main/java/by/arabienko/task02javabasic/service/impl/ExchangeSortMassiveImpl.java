package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SortMassiveService;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * service for sorting an array.
 * Bubble method. Sequential comparison and exchange
 * of adjacent elements, if the previous one is larger
 * than the next one (light elements slowly emerge).
 */
public class ExchangeSortMassiveImpl implements SortMassiveService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ExchangeSortMassiveImpl.class);

    @Override
    public Massive sortMassive(Massive massive) throws ServiceException {
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
            LOGGER.error(" Massive is empty.");
            throw new ServiceException("Operation on massive is not possible!");
        }

        LOGGER.debug("Exchange sort massive.");
        return massive;
    }
}
