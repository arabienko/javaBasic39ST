package by.arabienko.service.repository.specification.find.spec;

import by.arabienko.bean.entity.Shape;

/**
 * Parameter search specification interface.
 * @param <T> The entities that the classes will work with.
 */
public interface ShapeFindSpecification<T extends Shape> {
    /**
     * Method for comparing parameters
     * to form a sample by parameters.
     * @param t The entities.
     * @return boolean parameter.
     */
    boolean isSpecified(T t);
}
