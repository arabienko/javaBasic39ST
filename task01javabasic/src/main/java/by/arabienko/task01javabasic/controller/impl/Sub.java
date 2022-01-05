package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;

/**
 *
 */
public class Sub implements Command {

    @Override
    public Data exec(final Data data) {
        return data;
    }
}
