package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * ID search specification.
 */
public class ConeShapeFindByID
        extends AbstractSpecification<ConeShape> {
    private Long shapeID;

    public ConeShapeFindByID(final Long ID) {
        this.shapeID = ID;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getID().equals(shapeID);
    }
}
