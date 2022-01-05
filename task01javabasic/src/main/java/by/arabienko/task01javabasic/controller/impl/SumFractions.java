package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.CyclesService;
import by.arabienko.task01javabasic.view.InputOutputData;

public class SumFractions implements Command {

    @Override
    public Data exec(final Data newData) throws Exception {
        CyclesService service = new CyclesService();
        InputOutputData ioData = new InputOutputData();
        Data data = new Data();
        return ioData.input(data, service.sumFractions(newData.getData(0)));
    }
}
