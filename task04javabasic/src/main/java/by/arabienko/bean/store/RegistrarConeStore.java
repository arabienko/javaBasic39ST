package by.arabienko.bean.store;

import by.arabienko.bean.entity.Registrar;
import by.arabienko.bean.entity.RegistrarShape;
import by.arabienko.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements
 * the interface for storing
 * the parameters of the Cone entity.
 */
public class RegistrarConeStore implements RegistrarStore<RegistrarShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(RegistrarConeStore.class);
    private static final List<RegistrarShape>
            storeRegistrar = new ArrayList<>();

    /**
     * @param key ID Registrar
     * @return find registrar by ID
     */
    @Override
    public RegistrarShape getItemStore(final Long key) {
        for (RegistrarShape registrarShape : storeRegistrar) {
            if (registrarShape.getID().equals(key)) {
                return registrarShape;
            }
        }
        return null;
    }

    /**
     * Method add new registrar
     *
     * @param registrarShape
     */
    @Override
    public void addToStore(final RegistrarShape registrarShape) {
        if (!storeRegistrar.contains(registrarShape)) {
            storeRegistrar.add(registrarShape);
            LOGGER.debug("RegistrarShape was added " +
                    "to store." + registrarShape);
        } else {
            LOGGER.debug("The store has already contained " +
                    "a Registrar shape " + registrarShape);
        }
    }

    /**
     * @return copy List
     */
    @Override
    public List<RegistrarShape> getStore() {
        List<RegistrarShape> registrarShapes =
                new ArrayList<>(storeRegistrar);
        return registrarShapes;
    }

    /**
     * Method updates registrar
     *
     * @param registrar
     */
    @Override
    public void updateStore(final RegistrarShape registrar) throws ServiceException {
        List<RegistrarShape> registrarShapes =
                new ArrayList<>(storeRegistrar);
        Long registrarID = registrar.getID();
        int count = 0;
        for (RegistrarShape registrar1 : registrarShapes) {
            if (registrarID.equals(registrar1.getID())) {
                storeRegistrar.remove(registrar1);
                storeRegistrar.add(registrar);
                count++;
            }
        }
        if (count > 0){
            LOGGER.debug("RegistrarShape was updated " +
                    "to store." + registrar);
        } else {
            LOGGER.debug("The storage does not contain " +
                    "an object under ID= "+ registrarID);
            throw new ServiceException("The storage does not contain " +
                    "an object under ID: "+registrarID);
        }

    }

    /**
     * Method removes registrar
     *
     * @param registrarShape
     */
    @Override
    public void removeFromStore(final RegistrarShape registrarShape) {
        if (storeRegistrar.contains(registrarShape)) {
            storeRegistrar.remove(registrarShape);
            LOGGER.debug("RegistrarShape was updated " +
                    "to store." + registrarShape);
        } else {
            LOGGER.debug("The store does not contain " +
                    "a Registrar shape " + registrarShape);
        }
        LOGGER.debug("RegistrarShape was removed from store.");
    }
}
