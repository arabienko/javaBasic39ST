package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.bean.ArrayInterface;
import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.controller.command.CreatorArray;

import java.util.List;

/**
 * A class for creating a Matrix class
 */
public class MatrixCreatorArray extends CreatorArray {

    @Override
    public ArrayInterface factoryMethod(List list) {

        return new Matrix((Number[][]) list.get(0));
    }
}
