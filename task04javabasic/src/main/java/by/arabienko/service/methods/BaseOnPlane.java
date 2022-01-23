package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;

/**
 * Determines if the base lies on a plane.
 */
public class BaseOnPlane implements ICountService<ConeShape> {
    /**
     * @param shape cone entity
     * @return 1 - if cone base lies on plain,
     * 0 - if not.
     */
    @Override
    public double counting(ConeShape shape) {
        if (shape.getY()==0) {
            return 1;
        }
        return 0;
    }
}
