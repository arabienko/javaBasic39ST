package by.arabienko.creator.entity;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Registrar;
import by.arabienko.bean.entity.RegistrarShape;
import by.arabienko.creator.entity.CreatorRegistrar;

/**
 * Creation shape registrar
 */
public class CreatorRegistrarConeShape extends CreatorRegistrar {
    @Override
    public Registrar factoryMethod(Long ID, double volume,
                                   double surfaceArea,
                                   double ratioVolumes) {
        return new RegistrarShape(ID, volume,
                surfaceArea, ratioVolumes);
    }
}
