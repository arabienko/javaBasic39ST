package by.arabienko.creator.entity;

import by.arabienko.bean.entity.ConeShape;
import by.arabienko.bean.entity.Registrar;

/**
 * Abstract class registrar creator
 */
public abstract class CreatorRegistrar {
    public abstract Registrar factoryMethod(
            Long ID, double volume,
            double surfaceArea,
            double ratioVolumes);
}
