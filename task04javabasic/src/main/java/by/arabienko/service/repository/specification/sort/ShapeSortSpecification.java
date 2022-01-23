package by.arabienko.service.repository.specification.sort;

import by.arabienko.bean.entity.Shape;

import java.util.Comparator;

/**
 * Sort interface.
 * @param <T> shape
 */
public interface ShapeSortSpecification<T extends Shape> {
   /**
    * @return comparator
    */
   Comparator<T> sortComparator();
}
