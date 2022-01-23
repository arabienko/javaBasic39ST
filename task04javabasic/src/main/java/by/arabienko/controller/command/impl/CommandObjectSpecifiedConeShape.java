package by.arabienko.controller.command.impl;

import by.arabienko.bean.entity.Shape;
import by.arabienko.controller.command.Command;
import by.arabienko.service.methods.ICountService;
import by.arabienko.service.methods.ObjectSpecifiedConeShape;

/**
 * Object is Specified Cone Shape
 */
public class CommandObjectSpecifiedConeShape implements Command {
    @Override
    public double execute(Shape shape) {
        ICountService service = new ObjectSpecifiedConeShape();
        return service.counting(shape);
    }
}
