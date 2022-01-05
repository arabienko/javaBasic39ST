package by.arabienko.service;

import by.arabienko.entity.impl.Bank;
import by.arabienko.entity.impl.Credit;
import by.arabienko.service.impl.ParseDateFromFileJson;
import by.arabienko.service.impl.WriteDateToFileJson;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteDateToFileJsonTest {

    @Test
    void execute() throws IOException, ServiceException {
        IWorkWithFileJson writeDateToFileJson = new WriteDateToFileJson();
        IWorkWithFileJson parseDateFromFileJson = new ParseDateFromFileJson();

        Credit credit = new Credit("Lady","purchase of products",
                22.5,3,"Lady Club",5000);
        Credit credit1 = new Credit("Lady","purchase of products",
                30,3,"Lady Club",5000);

        List listCredit = new ArrayList();
        listCredit.add(credit);
        listCredit.add(credit1);
        Bank bank = new Bank("bank", listCredit);
        List listBankActual = new ArrayList();
        listBankActual.add(bank);

        List listDate = new ArrayList();
        String str = "save_result_test.json";

        listDate.add(listBankActual);
        listDate.add(str);

        writeDateToFileJson.workWithFile(listDate);

        List actual = new ArrayList();
        actual.add("testDateParse");
        List listExpected = parseDateFromFileJson.workWithFile(actual);

        assertEquals(listExpected, listBankActual);


    }
}
