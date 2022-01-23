package by.arabienko.service.repository.storage.impl;

import by.arabienko.creator.store.CreatorConeShapeStore;
import by.arabienko.bean.entity.RegistrarShape;
import by.arabienko.bean.store.RegistrarConeStore;
import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.repository.storage.RepositoryShape;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * {@link RepositoryRegistrarShape} class is
 * repository for ConeShape registrar
 */
public class RepositoryRegistrarShape implements RepositoryShape {
    private static final Logger LOGGER = LogManager.
            getLogger(RepositoryRegistrarShape.class);
    private static final RepositoryRegistrarShape INSTANCE =
            new RepositoryRegistrarShape();
    private RegistrarConeStore store = new CreatorConeShapeStore().
            createRegistrarStore();

    public static RepositoryRegistrarShape getInstance() {
        return INSTANCE;
    }

    public RepositoryRegistrarShape() {
    }

    /**
     * @param key ID
     * @return registrar
     */
    @Override
    public RegistrarShape getElement(Long key) {
        return store.getItemStore(key);
    }

    /**
     * add registrar to storage
     *
     * @param registrar
     */
    @Override
    public void addElement(Object registrar) {
        RegistrarShape registrarShape;
        Validation validation = new Validation();
        try {
            if (registrar instanceof RegistrarShape
            || registrar != null) {
                registrarShape = (RegistrarShape) registrar;
            } else {
                LOGGER.error("The object is not a cone registrar. " + registrar);
                throw new ServiceException(
                        "The object is not a cone registrar. " + registrar);
            }
            if (!store.getStore().contains(registrarShape)
                    || validation.dataAboveZero
                    (registrarShape.getVolume(),
                            registrarShape.getRatioVolumes(),
                            registrarShape.getRatioVolumes())) {
                store.addToStore(registrarShape);
            } else {
                LOGGER.error("No Registrar object recorded."
                        + registrarShape);
                throw new ServiceException("No registrar object recorded: "
                        + "The registrar is not correct."
                        + registrarShape);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Registrar shape was added: "
                + registrar);
    }

    /**
     * remove shape from storage
     *
     * @param registrar
     */
    @Override
    public void removeElement(Object registrar) {
        RegistrarShape coneShape;
        try {
            if (registrar instanceof RegistrarShape) {
                coneShape = (RegistrarShape) registrar;
            } else {
                LOGGER.error("No ConeShape object." + registrar);
                throw new ServiceException("No ConeShape object : " +
                        "The ConeShape is not correct. " + registrar);
            }
            store.removeFromStore(coneShape);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Registrar shape was removed: "
                + registrar);
    }

    /**
     * Update new registrar
     *
     * @param registrar
     */
    @Override
    public void updateElement(Object registrar) {
        RegistrarShape registrarShape;
        try {
            if (registrar instanceof RegistrarShape
            || registrar != null) {
                registrarShape = (RegistrarShape) registrar;
            } else {
                LOGGER.error("No registrar object rerecorded: "
                        + "The registrar is not a RegistrarShape. "
                        + registrar);
                throw new ServiceException("No registrar object rerecorded: "
                        + "The registrar is not a RegistrarShape. "
                        + registrar);
            }
            store.updateStore(registrarShape);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Registrar shape was updated: "
                + registrar);
    }
}
