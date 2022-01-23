package by.arabienko.service.repository.specification.find.spec;

import by.arabienko.bean.entity.Shape;

import java.util.ArrayList;
import java.util.List;


/**
 * A specification class to search
 * for at least two conditions.
 * @param <T> the entity.
 */
public class AndSpecification<T extends Shape>
        extends AbstractSpecification<T> {

    /**
     * Repository of search specifications.
     */
    private List<ShapeFindSpecification<T>> set = new ArrayList<>();

    public AndSpecification(final ShapeFindSpecification<T> a,
                            final ShapeFindSpecification<T> b) {
        set.add(a);
        set.add(b);
    }

    /**
     * Returns objects that satisfy
     * two conditions at the same time.
     * @param t the entity.
     * @return
     */
    @Override
    public boolean isSpecified(final T t) {
        for (ShapeFindSpecification<T> s : set) {
            if (!s.isSpecified(t)) {
                return false;
            }
        }
        return true;
    }

    public AbstractSpecification<T> and(final ShapeFindSpecification<T> s) {
        set.add(s);
        return this;
    }
}
