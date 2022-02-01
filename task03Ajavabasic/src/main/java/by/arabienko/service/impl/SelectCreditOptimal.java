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
 * Selects a loan that matches the special characteristics of the borrower.
 */
public class SelectCreditOptimal implements ISelectCredit {

    /**
     * Logging events.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(SelectCreditOptimal.class);

    @Override
    public List selectCredit(List listData, String purpose,
                             int selectBorrower, int amount)
            throws ServiceException {
        Validation validation = new Validation();
        List newListBankSuggest = new ArrayList();
        String borrower;
        List<Bank> listBanks = listData;
        Bank bankOptimal = null;
        List<Credit> creditOptimalList = new ArrayList<>();

        if (listData.get(0).equals("There is no suitable loan offer.")) {
            throw new ServiceException("No data for select optimal credit");
        }
        if (purpose.isBlank()) {
            LOGGER.debug("There is no suitable loan offer.");
            throw new ServiceException("No purpose for select optimal credit");
        } else {
            if (!validation.isNotEmpty(listData)) {
                throw new ServiceException("No date banks for select credit");
            }
            if (selectBorrower!=0) {
                switch (selectBorrower) {
                    case 1:
                        borrower = "large families";
                        break;
                    case 2:
                        borrower = "Military personnel";
                        break;
                    case 3:
                        borrower = "citizen RB";
                        break;
                    case 4:
                        borrower = "young specialist";
                        break;
                    case 5:
                        borrower = "Lady Club";
                        break;
                    case 6:
                        borrower = "On a universal basis";
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: "
                                + selectBorrower);
                }
                double minMonthPayment = amount;
                int saveCountBank = 0;
                Credit creditOptimal = null;
                int countBank = 0;
                for (Bank bank : listBanks) {
                    List<Credit> creditList = bank.getCredits();
                    for (Credit credit : creditList) {
                        credit.setAmount(amount);
                        if (credit.getBorrower().equals(borrower)) {
                            if (minMonthPayment >= credit.monthlyPayment()) {
                                minMonthPayment = credit.monthlyPayment();
                                creditOptimal = credit;
                                saveCountBank = countBank;
                            }
                        }
                    }
                    countBank++;
                }
                creditOptimalList.add(creditOptimal);
                bankOptimal = listBanks.get(saveCountBank);
                bankOptimal.setCredits(creditOptimalList);
            }
            if (validation.isNotEmpty(creditOptimalList)) {
                newListBankSuggest.add(bankOptimal);
            }
        }
        if (!validation.isNotEmpty(newListBankSuggest)) {
            LOGGER.debug("There is no suitable loan offer.");
            newListBankSuggest.
                    add("There is no suitable loan offer.");
        } else {
            LOGGER.debug("Optimal offer have been generated.");
        }
        return newListBankSuggest;
    }
}
