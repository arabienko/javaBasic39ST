package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Specified Cone Shape.
 */
public class ObjectSpecifiedConeShape implements ICountService<ConeShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(ObjectSpecifiedConeShape.class);
    /**
     * @param coneShape
     * @return 1 - if shape is cone,
     * else 0 - if not.
     */
    @Override
    public double counting(ConeShape coneShape) {
                if (coneShape instanceof ConeShape
                || coneShape != null) {
            if (coneShape.getRadius() > 0
                    & coneShape.getHigh() > 0) {
                return 1;
            }
        }
        LOGGER.debug("Shape is cone shape: "
                +coneShape);
        return 0;
    }
}
