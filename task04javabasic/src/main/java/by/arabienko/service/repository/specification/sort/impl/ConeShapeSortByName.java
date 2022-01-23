package by.arabienko.service.repository.specification.sort.impl;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.repository.specification.sort.ShapeSortSpecification;

import java.util.Comparator;

/**
 * Sort by cone name.
 */
public class ConeShapeSortByName implements ShapeSortSpecification {
    @Override
    public Comparator<ConeShape> sortComparator() {
        return Comparator.comparing(ConeShape::getNameShape).
                thenComparing(ConeShape::getID);
    }
}
