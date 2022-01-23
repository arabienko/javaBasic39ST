package by.arabienko.creator.entity;

import by.arabienko.bean.entity.Shape;

/**
 * Abstract class Factory method.
 */
public abstract class CreatorShape {
    public abstract Shape factoryMethod(String nameShape, double x,
                                        double y, double z,
                                        double radius, double high);

}
