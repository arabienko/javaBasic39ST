package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * ID range search specification.
 */
public class ConeShapeFindByIDRange extends AbstractSpecification<ConeShape> {
    private double minRange;
    private double maxRange;

    public ConeShapeFindByIDRange(final double min,
                                  final double max) {
        this.minRange = min;
        this.maxRange = max;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getID()>=minRange
                && coneShape.getID()<=maxRange;
    }
}
