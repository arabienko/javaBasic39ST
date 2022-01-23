package by.arabienko.bean.observer;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.CommandCountSurfaceArea;
import by.arabienko.controller.command.impl.CommandCountVolume;
import by.arabienko.controller.command.impl.CommandRatioVolumesFigureByPlane;
import by.arabienko.creator.entity.CreatorRegistrar;
import by.arabienko.creator.entity.CreatorRegistrarConeShape;
import by.arabienko.service.repository.storage.impl.RepositoryRegistrarShape;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Cone Object Change Observer
 */
public class ConeShapeObserver implements Observer {
    private static final Logger LOGGER =
            LogManager.getLogger(ConeShapeObserver.class);

    private ArrayList<ConeShape> list = new ArrayList<>();

    public void addObservable(ConeShape coneShape) {
        // adding an object to the observer list
        list.add(coneShape);
    }

    public void removeObservable(ConeShape coneShape) {
        // removing an object from the observer list
        list.remove(coneShape);
    }

    /**
     * Event Reacting Method
     * @param event Event Reacting Method
     */
    @Override
    public void handleEvent(ConeShapeEvent event) {
       Iterator<ConeShape> iterator = list.iterator();
        while (iterator.hasNext()) {
            ConeShape coneShape = iterator.next();
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
                            ID, volume,surfaceArea, ratioVolumes));
            LOGGER.debug("Changes in parameters" +
                    " have been recorded.");
        }
    }
}
