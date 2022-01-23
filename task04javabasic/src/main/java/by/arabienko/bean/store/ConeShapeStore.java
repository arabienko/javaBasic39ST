package by.arabienko.bean.store;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Shape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements
 * the Store interface,
 * which stores objects of
 * the Cone class.
 */
public class ConeShapeStore implements Store {
    private static final Logger LOGGER =
            LogManager.getLogger(ConeShapeStore.class);
    private static final List<ConeShape>
            storeCone = new ArrayList<>();

    @Override
    public List<ConeShape> getStore() {
        List<ConeShape> newList =
                new ArrayList<>(storeCone);
        return newList;
    }

    @Override
    public void updateStore(Shape shape) {
        ConeShape coneShape = (ConeShape) shape;
        List<ConeShape> coneShapes =
                new ArrayList<>(storeCone);
        Long registrarID = coneShape.getID();
        for (ConeShape coneShape1 : coneShapes) {
            if (registrarID.equals(coneShape1.getID())) {
                storeCone.remove(coneShape1);
                storeCone.add(coneShape);
            }
        }
    }

    @Override
    public void removeInStore(Shape shape){
        ConeShape coneShape = (ConeShape) shape;
        if (storeCone.contains(coneShape)) {
            storeCone.remove(coneShape);
        } else {
            LOGGER.debug("The store does not contain " +
                    "a cone object. " + coneShape);
        }
    }

    @Override
    public void addToStore(Shape shape) {
        storeCone.add((ConeShape) shape);
    }

    @Override
    public ConeShape getItemStore(Long key) {
        for (ConeShape shape : storeCone) {
            if (shape.getID().equals(key)) {
                return shape;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return storeCone.toString();
    }


}
