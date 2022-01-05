package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.CyclesService;

public class CalculateResultZ implements Command {

    @Override
    public Data exec(final Data newData) throws Exception {
        CyclesService service = new CyclesService();
        Data data = new Data();
        data.push(service.calculateResultZ());
        return data;
    }
}
