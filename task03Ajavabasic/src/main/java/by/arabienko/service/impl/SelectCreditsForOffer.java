package by.arabienko.service.impl;

import by.arabienko.entity.impl.Bank;
import by.arabienko.entity.impl.Credit;
import by.arabienko.service.ServiceException;
import by.arabienko.service.ISelectCredit;
import by.arabienko.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Advanced search for bank loans for specific purposes.
 */
public class SelectCreditsForOffer implements ISelectCredit {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.
            getLogger(SelectCreditsForOffer.class);

    @Override
    public List selectCredit(List listData, String purpose,
                             int term, int amountLoan)
            throws ServiceException {
        Validation validation = new Validation();
        if (!validation.isNotEmpty(listData)) {
            throw new ServiceException(
                    "No data for select credit");
        }
        List<Bank> listBanks = listData;
        List newListBankSuggest =
                new ArrayList<>();
        if (!validation.isNotEmpty(listData)) {
            throw new ServiceException(
                    "No data banks for select credit");
        }
        if (purpose.equals(
                "purchase of products")) {
            for (Bank bank : listBanks) {
                List<Credit> creditList =
                        bank.getCredits();
                List<Credit> listTempCredit =
                        new ArrayList<>();
                for (Credit credit : creditList) {
                    if ((purpose.equals(
                            credit.getPurposeLoan()))
                            && (amountLoan <= credit.getAmount())) {
                        listTempCredit.add(credit);
                    }
                }
                if (validation.isNotEmpty(
                        listTempCredit)) {
                    bank.setCredits(listTempCredit);
                    newListBankSuggest.add(bank);
                }
            }
        } else{
            for (Bank bank : listBanks) {
                List<Credit> creditList =
                        bank.getCredits();
                List<Credit> listTempCredit =
                        new ArrayList<>();
                for (Credit credit : creditList) {
                    if ((purpose.equals(credit.
                            getPurposeLoan()))) {
                        listTempCredit.add(credit);
                    }
                }
              if (validation.isNotEmpty(listTempCredit)) {
                    bank.setCredits(listTempCredit);
                    newListBankSuggest.add(bank);
                }
            }
        }
        if (!validation.isNotEmpty(newListBankSuggest)) {
            LOGGER.debug(
                    "There is no suitable loan offer.");
           newListBankSuggest.add(
                   "There is no suitable loan offer.");
        } else {
            LOGGER.debug(
                    "Offers have been generated.");
        }
        return newListBankSuggest;
    }
}
