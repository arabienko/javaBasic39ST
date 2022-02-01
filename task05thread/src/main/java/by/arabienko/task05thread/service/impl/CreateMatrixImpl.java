package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.service.CreateArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Create matrix with date1matrix from file.
 */
public class CreateMatrixImpl implements CreateArrayService {
    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(CreateMatrixImpl.class);

    @Override
    public List createArray(List list) {
        int rows = list.size();
        int columns = 0;
        List<Number []> listInt = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            String[] word = list.get(i).toString().trim().split(" ");
            Number [] numb = new Number [word.length];
            int j = 0;
            for (String string : word) {
                numb[j] = parseInt(string);
                j++;
            }
            columns = j;
            listInt.add(numb);
        }

        Number [][] massive = new Number [rows][columns];
        for (int i = 0; i < rows; i++) {
            massive[i] =listInt.get(i);
        }

        List newList = new ArrayList();
        newList.add(massive);

        LOGGER.debug(" Array created (matrix).");

        return newList;
    }
}
