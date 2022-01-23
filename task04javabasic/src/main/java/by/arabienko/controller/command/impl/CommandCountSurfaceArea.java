package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.methods.CountSurfaceArea;
import by.arabienko.service.methods.ICountService;

/**
 * Command returns surface cone area
 */
public class CommandCountSurfaceArea implements Command {
    @Override
    public double execute(Shape shape) {
        ICountService service = new CountSurfaceArea();
        return service.counting(shape);
    }
}
