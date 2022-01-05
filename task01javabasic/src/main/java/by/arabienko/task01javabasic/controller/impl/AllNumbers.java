package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.CyclesService;

/**
 * Numbers not exceeding a given number N,
 * which are divisible by all their digits without a remainder.
 */
public class AllNumbers implements Command {

    @Override
    public Data exec(final Data newData) throws Exception {
        CyclesService service = new CyclesService();
        return service.allNumbers(newData.getData(0));
    }
}
