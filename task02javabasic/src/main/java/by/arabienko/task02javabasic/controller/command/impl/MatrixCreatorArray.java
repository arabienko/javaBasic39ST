package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.bean.ArrayInterface;
import by.arabienko.task02javabasic.bean.impl.Matrix;
import by.arabienko.task02javabasic.controller.command.CreatorArray;

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
