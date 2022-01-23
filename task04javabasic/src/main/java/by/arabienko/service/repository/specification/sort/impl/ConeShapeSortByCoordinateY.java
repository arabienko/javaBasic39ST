package by.arabienko.service.repository.specification.sort.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.sort.ShapeSortSpecification;

import java.util.Comparator;

/**
 * Sort by coordinate Y
 */
public class ConeShapeSortByCoordinateY implements ShapeSortSpecification {
    @Override
    public Comparator sortComparator() {
        return Comparator.comparing(ConeShape::getY).
                thenComparing(ConeShape::getID);
    }
}
