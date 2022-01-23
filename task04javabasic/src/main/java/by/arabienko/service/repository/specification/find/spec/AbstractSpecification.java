package by.arabienko.service.repository.specification.find.spec;

import by.arabienko.bean.entity.Shape;

/**
 * An abstract class specification
 * for finding entities.
 * @param <T> the entity.
 */
public abstract class AbstractSpecification<T extends Shape>
        implements ShapeFindSpecification<T> {

    /**
     * @param t The entities.
     * @return boolean parameter
     * comparing two entities.
     */
    public abstract boolean isSpecified(T t);

    public AbstractSpecification<T> or(final ShapeFindSpecification<T> s) {
        return new OrSpecification(this, s);
    }

    public AbstractSpecification<T> and(final ShapeFindSpecification<T> s) {
        return new AndSpecification(this, s);
    }

    public AbstractSpecification<T> not() {
        return new NotSpecification(this);
    }
}
