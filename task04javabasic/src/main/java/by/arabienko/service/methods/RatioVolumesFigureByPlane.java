package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Finds the ratio of volumes
 * when sectioned by the X plane
 */
public class RatioVolumesFigureByPlane implements ICountService<ConeShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(RatioVolumesFigureByPlane.class);
    /**
     * @param coneShape
     * @return Finds the ratio of volumes
     * when sectioned by the X plane
     */
    @Override
    public double counting(ConeShape coneShape) {
        double count = 0;
        Validation validation = new Validation();
        try {
            if (!validation.dataAboveZero(
                    coneShape.getHigh(),
                    coneShape.getRadius())) {
                throw new ServiceException("The object is not ConeShape" +
                        coneShape);
            }
            if (coneShape.getY() > 0 &
                    (coneShape.getHigh() -
                            coneShape.getY()) <= 0) {
                return count;
            }
            double highNewCone = coneShape.getHigh() -
                    coneShape.getY();
            double radiusNewCone = (highNewCone
                    / coneShape.getRadius()) *
                    coneShape.getRadius();
            count = countVolume(highNewCone, radiusNewCone)
                    / countVolume(coneShape.getHigh(),
                            coneShape.getRadius());
    } catch(
    ServiceException e)

    {
        e.printStackTrace();
    }
        LOGGER.debug("the ratio of volumes: "+count);
        return count;
}

    /**
     * @param high
     * @param radius
     * @return volume cone value.
     * @throws ServiceException
     */
    private static double countVolume(double high,
                                      double radius)
            throws ServiceException {
        final double coefficient = 1.0 / 3.0;
        final int degree = 2;
        return coefficient * Math.PI *
                Math.pow(radius, degree) *
                high;
    }
}
