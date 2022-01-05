package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.GeometryService;
import by.arabienko.task01javabasic.view.InputOutputData;

/**
 *
 */
public class Second implements Command {
    @Override
    public Data exec(final Data newData) {
        GeometryService service = new GeometryService();
        InputOutputData ioData = new InputOutputData();
        Data dataResult = new Data();
        ioData.input(dataResult, service.second(newData.getData(0)));
        return dataResult;
    }
}
