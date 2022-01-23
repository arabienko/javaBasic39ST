package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.CommandCountSurfaceArea;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Search specification by condition:
 * surface area in range.
 */
public class ConeShapeFindInRangeSurfaceAreas
        extends AbstractSpecification<ConeShape> {
    private double minArea;
    private double maxArea;

    public ConeShapeFindInRangeSurfaceAreas(final double fromArea,
                                      final double toArea) {
        this.minArea = fromArea;
        this.maxArea = toArea;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        Command command = new CommandCountSurfaceArea();
        return command.execute(coneShape) >= minArea
                && command.execute(coneShape) <= maxArea;
    }
}
