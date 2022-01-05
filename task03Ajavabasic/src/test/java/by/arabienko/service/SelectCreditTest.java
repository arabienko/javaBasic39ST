package by.arabienko.service;

import by.arabienko.entity.impl.Bank;
import by.arabienko.entity.impl.Credit;
import by.arabienko.service.impl.SelectCreditOptimal;
import by.arabienko.service.impl.SelectCreditsForOffer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SelectCreditTest {

    static Stream<Arguments> testOffersDataProvider() {
        Credit creditSuggest1 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 5000);
        Credit creditSuggest2 = new Credit("Lady", "purchase of products",
                22.5, 4, "Lady Club", 5000);
        Credit creditSuggest3 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 6000);
        List listCredit = new ArrayList();
        listCredit.add(creditSuggest1);
        listCredit.add(creditSuggest2);
        listCredit.add(creditSuggest3);
        Bank bank = new Bank("bank", listCredit);
        List expectedList = new ArrayList();
        expectedList.add(bank);

        Credit creditSuggest12 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 5000);
        Credit creditSuggest22 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 2000);
        List listCredit2 = new ArrayList();
        listCredit2.add(creditSuggest12);
        listCredit2.add(creditSuggest22);
        Bank bank2 = new Bank("bank", listCredit2);
        List expectedList2 = new ArrayList();
        expectedList2.add(bank2);

        Credit creditSuggest13 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 6000);

        List listCredit3 = new ArrayList();
        listCredit3.add(creditSuggest13);
        Bank bank3 = new Bank("bank", listCredit3);
        List expectedList3 = new ArrayList();
        expectedList3.add(bank3);
        List expectedList4 = new ArrayList();
        expectedList4.add("There is no suitable loan offer.");

        Credit credit1 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 5000);
        Credit credit2 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 2000);
        Credit credit3 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 5000);
        Credit credit4 = new Credit("Lady", "purchase of products",
                22.5, 4, "Lady Club", 5000);
        Credit credit5 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 6000);
        List l1 = new ArrayList();
        l1.add(credit1);
        l1.add(credit2);
        l1.add(credit3);
        l1.add(credit4);
        l1.add(credit5);
        Bank bankOffers = new Bank("bank", l1);
        Bank bankOffers2 = new Bank("bank", l1);
        Bank bankOffers3 = new Bank("bank", l1);
        Bank bankOffers4 = new Bank("bank", l1);

        return Stream.of(
                arguments(expectedList, bankOffers, "purchase of products", 3, 5000),
                arguments(expectedList2, bankOffers2, "home purchase", 3, 1000),
                arguments(expectedList3, bankOffers3, "purchase of products", 3, 6000),
                arguments(expectedList4, bankOffers4, "purchase of products", 3, 9000)
        );
    }

    @ParameterizedTest
    @MethodSource("testOffersDataProvider")
    void testSelectOfferCredit(List listExpected, Bank bankOffers, String purpose, int term, int amount) throws ServiceException {

        SelectCreditsForOffer selectCreditsForOffer = new SelectCreditsForOffer();

        List listBanks = new ArrayList();
        listBanks.add(bankOffers);
        List actualList = selectCreditsForOffer.selectCredit(listBanks, purpose, term, amount);
        assertEquals(listExpected.get(0), actualList.get(0));
    }

    static Stream<Arguments> testOptimalDataProvider() {
        Credit creditSuggest1 = new Credit("Lady", "home purchase",
                30, 3, "Military personnel", 5000);
        List listCredit = new ArrayList();
        listCredit.add(creditSuggest1);
        Bank bankExpected = new Bank("bank", listCredit);
        List expectedList = new ArrayList();
        expectedList.add(bankExpected);
        Credit creditSuggest2 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 5000);
        List listCredit2 = new ArrayList();
        listCredit2.add(creditSuggest2);
        Bank bankExpected2 = new Bank("bank", listCredit2);
        List expectedList2 = new ArrayList();
        expectedList2.add(bankExpected2);
        List expectedList3 = new ArrayList();
        expectedList3.add("No data for select optimal credit");
        Bank bankExpected4 = new Bank("bank", listCredit2);
        List expectedList4 = new ArrayList();
        expectedList4.add("There is no suitable loan offer.");
        Credit credit1 = new Credit("Lady", "home purchase",
                22.5, 3, "Lady Club", 5000);
        Credit credit2 = new Credit("Lady", "home purchase",
                30, 3, "Lady Club", 5000);
        Credit credit3 = new Credit("Lady", "home purchase",
                30, 3, "-----", 5000);
        Credit credit4 = new Credit("Lady", "home purchase",
                30, 3, "Military personnel", 6000);
        Credit credit5 = new Credit("Lady", "home purchase",
                30, 3, "Military personnel", 5000);
        List l1 = new ArrayList();
        l1.add(credit1);
        l1.add(credit2);
        l1.add(credit3);
        l1.add(credit4);
        l1.add(credit5);
        Bank bank1 = new Bank("bank", l1);
        List listBanks = new ArrayList();
        listBanks.add(bank1);
        List listBanks2 = new ArrayList();
        Bank bank2 = new Bank("bank", l1);
        listBanks2.add(bank2);
        List listBanks3 = new ArrayList();
        Bank bank3 = new Bank("bank", l1);
        listBanks3.add("There is no suitable loan offer.");
        List listBanks4 = new ArrayList();
        Bank bank4 = new Bank("bank", l1);
        listBanks4.add(bank4);

        return Stream.of(
                arguments(expectedList, listBanks, "home purchase", 2, 5000),
                arguments(expectedList2, listBanks2, "home purchase", 5, 5000),
                arguments(expectedList4, listBanks4, "home purchase", 0, 5000),
                arguments(expectedList3, listBanks3, "home purchase", 5, 5000)

        );
    }

    @ParameterizedTest
    @MethodSource("testOptimalDataProvider")
    public void testSelectOptimalCredit(List bankExpected, List offerBanks,
                                        String purpose, int selectBorrower, int amount ) throws ServiceException {

        SelectCreditOptimal selectCreditOptimal = new SelectCreditOptimal();
        List actualList = selectCreditOptimal.selectCredit(offerBanks, purpose, selectBorrower, amount);
        assertEquals(bankExpected.get(0),actualList.get(0));
    }
}
