package by.arabienko.service;

import by.arabienko.entity.impl.Bank;
import by.arabienko.entity.impl.Credit;
import by.arabienko.service.impl.ParseDateFromFileJson;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ParseDateFromFileJsonTest {
    ParseDateFromFileJson workWithFileJson = new ParseDateFromFileJson();
    static Stream<Arguments> testArgumentsDataProvider() {
        Credit credit = new Credit("Lady", "purchase of products",
                22.5, 3, "Lady Club", 5000);
        Credit credit1 = new Credit("Lady", "purchase of products",
                30, 3, "Lady Club", 5000);
        List listCredit = new ArrayList();
        listCredit.add(credit);
        listCredit.add(credit1);
        Bank bank = new Bank("bank", listCredit);
        List expectedList = new ArrayList();
        expectedList.add(bank);
        List actual = new ArrayList();
        List actual2 = new ArrayList();
        actual.add("fileTest");
        actual2.add("");
        return Stream.of(
                arguments(actual, expectedList),
                arguments(actual2,expectedList)

        );
    }
    @ParameterizedTest
    @MethodSource("testArgumentsDataProvider")
    void execute(List actual, List expectedList) throws IOException, ServiceException {
        List listActual = workWithFileJson.workWithFile(actual);

        assertEquals(listActual, expectedList);
    }
}
