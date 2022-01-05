package by.arabienko.task01javabasic.controller.impl;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.service.GeometryService;

/**
 *
 */
public class Transformation implements Command {

    @Override
    public Data exec(final Data newData) {
        GeometryService service = new GeometryService();
        return service.radToDegree(newData.getData(0));
    }
}
