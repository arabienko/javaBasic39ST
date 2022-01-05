package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.ArithmeticService;

/**
 *
 */
public class Sum implements Command {
    //todo iodate-
    @Override
    public Data exec(final Data data) {
        ArithmeticService service = new ArithmeticService();
        Data dataResult = new Data();
        dataResult.push(service.sum(data.getData(0), data.getData(1)));
        return dataResult;
    }
}
