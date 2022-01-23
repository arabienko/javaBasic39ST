package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.methods.CountVolume;
import by.arabienko.service.methods.ICountService;

/**
 * Command returns cone volume.
 */
public class CommandCountVolume implements Command {
    @Override
    public double execute(Shape shape) {
        ICountService service = new CountVolume();
        return service.counting(shape);
    }
}
