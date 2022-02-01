package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.CreateArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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
        String[] word = ((String) list.get(0)).toString().trim().split(" ");
        Number[] numb = new Number[word.length];
        for (int j = 0; j < word.length; j++) {
            numb[j] = Integer.parseInt(word[j]);
        }
        listInt.add(numb);

        LOGGER.debug(" Array created (massive).");

        return listInt;
    }
}
