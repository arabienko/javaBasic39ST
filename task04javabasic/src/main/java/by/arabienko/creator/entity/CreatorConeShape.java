package by.arabienko.creator.entity;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import by.arabienko.bean.observer.ConeShapeObserver;
import by.arabienko.bean.observer.Observer;
import by.arabienko.service.repository.storage.impl.RepositoryConeShape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Factory method for creation different shapes:
 * point and cone.
 */
public class CreatorConeShape extends CreatorShape {
    private static final Logger LOGGER =
            LogManager.getLogger(CreatorConeShape.class);

    @Override
    public Shape factoryMethod(String nameShape, double x, double y, double z,
                               double radius, double high) {
        ConeShape coneShape = new ConeShape(
                nameShape, x, y, z, high, radius);
        Observer observer = new ConeShapeObserver();
        //recreating the corresponding registrar
        // and updating it in the repository
        coneShape.addObserver((ConeShapeObserver) observer);
        RepositoryConeShape.getInstance().addElement(coneShape);
        LOGGER.debug("recreating the corresponding registrar " +
                "and updating it in the repository"+ coneShape);
        return coneShape;
    }
}
