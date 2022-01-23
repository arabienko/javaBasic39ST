package by.arabienko.service.repository.storage.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.CommandCountSurfaceArea;
import by.arabienko.controller.command.impl.CommandCountVolume;
import by.arabienko.controller.command.impl.CommandObjectSpecifiedConeShape;
import by.arabienko.controller.command.impl.CommandRatioVolumesFigureByPlane;
import by.arabienko.creator.store.CreatorConeShapeStore;
import by.arabienko.creator.entity.CreatorRegistrar;
import by.arabienko.creator.entity.CreatorRegistrarConeShape;
import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.store.ConeShapeStore;
import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.repository.specification.find.spec.ShapeFindSpecification;
import by.arabienko.service.repository.storage.RepositoryShape;
import by.arabienko.service.validation.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@link RepositoryConeShape} class is Repository for ConeShape
 */
public final class RepositoryConeShape
        implements RepositoryShape<ConeShape> {
    private static final Logger LOGGER =
            LogManager.getLogger(RepositoryConeShape.class);
    private ConeShapeStore store =
            new CreatorConeShapeStore().createStore();
    private static final RepositoryConeShape INSTANCE =
            new RepositoryConeShape();

    public static RepositoryConeShape getInstance() {
        return INSTANCE;
    }

    public RepositoryConeShape() {
    }

    /**
     * @param key ID
     * @return cone shape
     */
    @Override
    public ConeShape getElement(final Long key) {
        return store.getItemStore(key);
    }

   /* public Optional<ConeShape> getItemByID(final Long key) {
        return Optional.ofNullable(store.getItemStore(key));
    }*/

    /**
     * add shape to storage
     *
     * @param shape
     */
    @Override
    public void addElement(final ConeShape shape) {
        Validation validation = new Validation();
        try {
            Command command = new CommandObjectSpecifiedConeShape();
            if (command.execute(shape)==0) {
                LOGGER.debug("The object is not Cone: -"
                        + shape);
                throw new ServiceException("The object is not Cone: -"
                        + shape);
            }
            if (!store.getStore().contains(shape)
                    || validation.dataAboveZero(
                    shape.getRadius(),
                    shape.getHigh())) {
                store.addToStore(shape);
                addToRegistrar(shape);
                LOGGER.debug("The cone object and "
                        + "its parameters are added " +
                        "to the repository");
            } else {
                LOGGER.error("No Cone object recorded." + shape);
                throw new ServiceException("No Cone object recorded: "
                        + "The shape is not a cone." + shape);

            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        LOGGER.debug("Cone shape was added: "
                + shape);
    }

    /**
     * @param coneShape A static method that adds data about the figure
     *                  to the registrar repository: surface area, volume,
     *                  and ratios of the volumes of the cone obtained
     *                  when cut by the coordinate plane.
     */
    private static void addToRegistrar(final ConeShape coneShape)
            throws ServiceException {
        Command command = new CommandCountVolume();
        double volume = command.execute(coneShape);
        command = new CommandCountSurfaceArea();
        double surfaceArea = command.execute(coneShape);
        command = new CommandRatioVolumesFigureByPlane();
        double ratioVolumes = command.execute(coneShape);
        Long ID = coneShape.getID();
        CreatorRegistrar creatorRegistrar =
                new CreatorRegistrarConeShape();
        RepositoryRegistrarShape.getInstance().
                addElement(creatorRegistrar.factoryMethod(
                        ID, volume, surfaceArea, ratioVolumes));
    }

    /**
     * remove shape from storage
     *
     * @param shape
     */
    public void removeElement(final ConeShape shape) {
        Command command = new CommandObjectSpecifiedConeShape();
        try {
            if (command.execute(shape) == 0) {
                LOGGER.debug("The object is not Cone: -"
                        + shape);
                throw new ServiceException("The object is not Cone: -"
                        + shape);
            }
            store.removeInStore(shape);
            RepositoryRegistrarShape.getInstance().removeElement(
                    RepositoryRegistrarShape.getInstance().
                            getElement(shape.getID()));
            LOGGER.debug("Cone shape was removed: "
                    + shape);
        }catch (ServiceException e){
            e.printStackTrace();
        }
    }

    /**
     * Update new shape
     *
     * @param shape
     */
    @Override
    public void updateElement(final ConeShape shape) {
        Command command = new CommandObjectSpecifiedConeShape();
        try {
            if (command.execute(shape) == 0) {
                LOGGER.debug("The object is not Cone: -"
                        + shape);
                throw new ServiceException("The object is not Cone: -"
                        + shape);
            }
            store.updateStore(shape);
        }catch (ServiceException e){
            e.printStackTrace();
        }
        }

        public List<ConeShape> sort ( final Comparator<? super ConeShape>
        comparator){
            LOGGER.debug("Object was update.");
            return store.getStore().
                    stream().
                    sorted(comparator).
                    collect(Collectors.toList());
        }

        /**
         * @param specification
         * @return new list according to specification
         */
        public List<ConeShape> query (
                ShapeFindSpecification specification){
            List<ConeShape> result =
                    store.getStore().stream().
                            filter(specification::isSpecified).
                            collect(Collectors.toList());
            if (result.isEmpty()) {
                LOGGER.debug("There are no Cones matching " +
                        "these parameters: "
                        + specification);
                return null;
            }
            LOGGER.debug("Result query: "
                    + result);
            return result;
        }
    }
