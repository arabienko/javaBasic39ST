package by.arabienko.service.repository.specification.find.spec;

import by.arabienko.bean.entity.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * At least one-condition of conditions
 * search specification: OR.
 * @param <T> The entities.
 */
public class OrSpecification<T extends Shape> extends AbstractSpecification<T> {

    /**
     * Repository of search specifications.
     */
    private List<ShapeFindSpecification<T>> set = new ArrayList<>();


    public OrSpecification(final ShapeFindSpecification specification,
                           final ShapeFindSpecification other) {
      set.add(specification);
      set.add(other);
    }

    /**
     * @param shape the object
     * @return returns objects
     * that match at least one
     * search parameter.
     */
    @Override
    public boolean isSpecified(final T shape) {
        for (ShapeFindSpecification<T> s : set) {
            if (s.isSpecified(shape)) {
                return true;
            }
        }
        return false;
    }

    public AbstractSpecification<T> or(final ShapeFindSpecification<T> s) {
        set.add(s);
        return this;
    }
}
