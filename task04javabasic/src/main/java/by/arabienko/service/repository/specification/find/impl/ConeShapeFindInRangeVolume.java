package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.CommandCountVolume;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Search specification by condition:
 * volume in range.
 */
public class ConeShapeFindInRangeVolume
        extends AbstractSpecification<ConeShape> {
    private double minValue;
    private double maxValue;

    public ConeShapeFindInRangeVolume(final double fromVolume,
                                      final double toVolume) {
        this.minValue = fromVolume;
        this.maxValue = toVolume;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        Command command = new CommandCountVolume();
        return command.execute(coneShape) >= minValue
                && command.execute(coneShape) <= maxValue;
    }
}
