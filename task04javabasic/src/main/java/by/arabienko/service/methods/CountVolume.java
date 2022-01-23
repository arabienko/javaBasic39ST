package by.arabienko.service.methods;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Count cone Volume
 */
public class CountVolume implements ICountService<ConeShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(CountVolume.class);

    /**
     * @param coneShape cone.
     * @return cone volume
     */
    @Override
    public double counting(ConeShape coneShape) {
        Validation validation = new Validation();
        final double coefficient = 1.0 / 3.0;
        final int degree = 2;
        double count = 0;
        try {
            if (coneShape.equals(null)
                    || validation.dataAboveZero(
                    coneShape.getHigh(), coneShape.getRadius())) {
                count = coefficient * Math.PI *
                        Math.pow(coneShape.getRadius(), degree) *
                        coneShape.getHigh();
            } else {
                throw new ServiceException("The object is not ConeShape " + coneShape);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Surface area: "+count
                + " ,cone: "+coneShape);
        return count;
    }
}
