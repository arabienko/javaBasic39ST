package by.arabienko.service.repository.specification.find.spec;

import by.arabienko.bean.entity.Shape;

/**
 * Specification class
 * for reverse search by parameters.
 * @param <T> the entity.
 */
public class NotSpecification<T extends Shape>
        extends AbstractSpecification<T> {

    private ShapeFindSpecification<T> specification;

    public NotSpecification(final ShapeFindSpecification spec) {
        this.specification = spec;
    }

    /**
     * @param t the entity for compare.
     * @return boolean parameter
     * reverse searching.
     */
    @Override
    public boolean isSpecified(final T t) {
        return !specification.isSpecified(t);
    }
}
