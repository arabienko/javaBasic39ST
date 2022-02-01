package by.arabienko.service;

import java.util.List;

/**
 * Interface for working with loan offers.
 */
public interface ISelectCredit {

    List selectCredit(List listData,
                      String purpose,
                      int numberInt,
                      int amount)
            throws ServiceException;

}
