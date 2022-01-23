package by.arabienko.service.repository.specification.find.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.find.spec.AbstractSpecification;

/**
 * Name search specification.
 */
public class ConeShapeFindByName extends AbstractSpecification<ConeShape> {
    private String nameShape;

    public ConeShapeFindByName(final String name) {
        this.nameShape = name;
    }

    @Override
    public boolean isSpecified(final ConeShape coneShape) {
        return coneShape.getNameShape().equals(nameShape);
    }
}
