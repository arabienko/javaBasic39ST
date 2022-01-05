package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.ExpressionService;
import by.arabienko.task01javabasic.view.InputOutputData;

public class FunctionExecute implements Command {
    @Override
    public Data exec(final Data newData) throws Exception {
        ExpressionService service = new ExpressionService();
        InputOutputData ioData = new InputOutputData();
        Data dataResult = new Data();
        ioData.input(dataResult, service.functionExecute(newData.getData(0)));
        return dataResult;
    }
}
