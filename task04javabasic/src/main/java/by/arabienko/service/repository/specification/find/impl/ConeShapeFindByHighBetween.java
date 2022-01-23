package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Height search specification.
 */
public class ConeShapeFindByHighBetween
        extends AbstractSpecification<ConeShape> {
    private double minRange;
    private double maxRange;
    public ConeShapeFindByHighBetween(final double min,
                                      final double max) {
        this.minRange = min;
        this.maxRange = max;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getHigh() >= minRange
                && coneShape.getHigh() <= maxRange;
    }
}
