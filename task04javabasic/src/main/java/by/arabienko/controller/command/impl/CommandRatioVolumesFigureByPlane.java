package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.methods.ICountService;
import by.arabienko.service.methods.RatioVolumesFigureByPlane;

/**
 * Command returns' ratio of figure volumes cut by plane.
 */
public class CommandRatioVolumesFigureByPlane implements Command {

    @Override
    public double execute(Shape shape) {
        ICountService service = new RatioVolumesFigureByPlane();
        return service.counting(shape);
    }
}
