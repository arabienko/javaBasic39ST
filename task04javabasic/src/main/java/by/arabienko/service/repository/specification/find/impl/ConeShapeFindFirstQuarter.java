package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Conditional search specification:
 * whether the base lies on a plane.
 */
public class ConeShapeFindFirstQuarter
        extends AbstractSpecification<ConeShape> {
    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getX() >= 0
                && coneShape.getY() >= 0
                && coneShape.getZ() >= 0;
    }
}
