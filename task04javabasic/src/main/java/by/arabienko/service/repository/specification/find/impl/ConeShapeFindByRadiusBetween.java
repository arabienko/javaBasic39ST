package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Radius range search specification.
 */
public class ConeShapeFindByRadiusBetween
        extends AbstractSpecification<ConeShape> {
    private double minRange;
    private double maxRange;

    public ConeShapeFindByRadiusBetween(final double min,
                                        final double max) {
        this.minRange = min;
        this.maxRange = max;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getRadius()>=minRange &&
                coneShape.getRadius()<=maxRange;
    }
}
