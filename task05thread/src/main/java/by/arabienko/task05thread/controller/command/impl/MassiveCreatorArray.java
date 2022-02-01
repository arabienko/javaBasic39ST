package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.bean.ArrayInterface;
import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.controller.command.CreatorArray;

import java.util.List;

/**
 * A class for creating a Massive class
 */
public class MassiveCreatorArray extends CreatorArray {

    @Override
    public ArrayInterface factoryMethod(List list) {

        return new Massive((Number[]) list.get(0));
    }
}
