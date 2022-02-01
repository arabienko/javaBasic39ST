package by.arabienko.task05thread.controller.command;

import by.arabienko.task05thread.bean.ArrayInterface;

import java.util.List;

/**
 * An abstract class for creating Entity Classes.
 */
public abstract class CreatorArray {

    public abstract ArrayInterface factoryMethod(List list);
}
