package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.ExpressionService;
import by.arabienko.task01javabasic.view.InputOutputData;

/**
 *
 */
public class Expression implements Command {

    @Override
    public Data exec(final Data newData) {
        ExpressionService service = new ExpressionService();
        InputOutputData ioData = new InputOutputData();
        Data dataResult = new Data();
        ioData.input(dataResult, service.cubicExpression(newData.getData(0),
                newData.getData(1), newData.getData(2),
                newData.getData(3), newData.getData(4)));
        return dataResult;
    }
}
