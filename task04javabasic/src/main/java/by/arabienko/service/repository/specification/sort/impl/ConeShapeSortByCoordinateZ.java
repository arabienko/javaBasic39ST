package by.arabienko.service.repository.specification.sort.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.sort.ShapeSortSpecification;

import java.util.Comparator;

/**
 * Sort by coordinate Z
 */
public class ConeShapeSortByCoordinateZ implements ShapeSortSpecification {
    @Override
    public Comparator sortComparator() {
        return Comparator.comparing(ConeShape::getZ).
                thenComparing(ConeShape::getID);
    }
}
