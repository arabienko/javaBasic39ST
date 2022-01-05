package by.arabienko.task02javabasic.controller.command;

import by.arabienko.task02javabasic.bean.ArrayInterface;

import java.util.List;

/**
 * An abstract class for creating Entity Classes.
 */
public abstract class CreatorArray {

    public abstract ArrayInterface factoryMethod(List list);
}
