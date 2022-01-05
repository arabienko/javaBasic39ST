package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.ExpressionService;
import by.arabienko.task01javabasic.view.InputOutputData;

public class MaxMinCompareNumber implements Command {
    @Override
    public Data exec(final Data newData) throws Exception {
        ExpressionService service = new ExpressionService();
        InputOutputData ioData = new InputOutputData();
        Data data = new Data();
        return ioData.input(data,
                service.maxMinCompareNumber(newData.getData(0),
                        newData.getData(1), newData.getData(2)));
    }
}
