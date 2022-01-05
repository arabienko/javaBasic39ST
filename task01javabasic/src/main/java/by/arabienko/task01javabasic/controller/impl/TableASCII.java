package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.CyclesService;

public class TableASCII implements Command {
    @Override
    public Data exec(final Data newData) throws Exception {
        CyclesService service = new CyclesService();
        service.tableASCII();
        return null;
    }
}
