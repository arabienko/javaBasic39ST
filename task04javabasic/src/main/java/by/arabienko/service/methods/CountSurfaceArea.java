package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Counting surface cone area.
 */
public class CountSurfaceArea implements ICountService<ConeShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(CountSurfaceArea.class);

    /**
     * @param coneShape cone shape.
     * @return surface cone area.
     */
    @Override
    public double counting(ConeShape coneShape) {
        double count = 0;
        try {
            count = baseArea(coneShape.getRadius()) +
                    surfaceArea(coneShape.getRadius(),
                            coneShape.getHigh());

        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Surface area: "+count
        + " ,cone: "+coneShape);
        return count;
    }

    /**
     * @param radius
     * @return base area
     * @throws ServiceException
     */
    private static double baseArea(double radius) throws ServiceException {
        Validation validation = new Validation();
        final int degree = 2;
        if (!validation.dataAboveZero(radius)) {
            throw new ServiceException("The object is not Cone," +
                    "param above zero. " + radius);
        }
        return Math.PI * Math.pow(radius, degree);
    }

    /**
     * @param radius
     * @param high
     * @return surface area.
     * @throws ServiceException
     */
    private static double surfaceArea(double radius, double high) throws ServiceException {
        Validation validation = new Validation();
        final int degree = 2;
        if (!validation.dataAboveZero(radius, high)) {
            throw new ServiceException("The object is not Cone," +
                    "param above zero. " + high);
        }
        final double l = Math.sqrt(Math.pow(radius, degree) +
                Math.pow(high, degree));
        return Math.PI * radius * l;
    }
}
