package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.CyclesService;

public class DisplayNumbers implements Command {
    @Override
    public Data exec(final Data newData) throws Exception {
        CyclesService service = new CyclesService();
        service.displayNumbers(newData.getData(0), newData.getData(0));
        return null;
    }
}
