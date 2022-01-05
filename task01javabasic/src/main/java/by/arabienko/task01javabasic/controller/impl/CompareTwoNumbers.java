package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.ExpressionService;

public class CompareTwoNumbers implements Command {

    @Override
    public Data exec(final Data newData) {
        ExpressionService service = new ExpressionService();
        service.compareNumber(newData.getData(0),
                newData.getData(1));
        return null;
    }
}
