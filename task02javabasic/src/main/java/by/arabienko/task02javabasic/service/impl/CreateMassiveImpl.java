package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.service.CreateArrayService;
import by.arabienko.task02javabasic.view.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Create massive with dates from file.
 */
public class CreateMassiveImpl implements CreateArrayService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(CreateMassiveImpl.class);

    @Override
    public List createArray(List list) {

        List listInt = new ArrayList<>();
        String[] word = list.get(0).toString().split(" ");
        Number[] numb = new Number[word.length];
        for (int j = 0 ; j< word.length; j++) {
            numb[j] = parseInt(word[j]);
        }
        listInt.add(numb);

        LOGGER.debug(" Array created (massive).");

        return listInt;
    }
}
