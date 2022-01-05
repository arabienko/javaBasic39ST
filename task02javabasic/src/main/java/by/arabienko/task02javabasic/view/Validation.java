package by.arabienko.task02javabasic.view;

import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.bean.impl.Matrix;

/**
 * valid parameters for expressions.
 */
public class Validation<T>{

    /**
     * Checking equals first matrix line and second matrix column.
     * @param matrixOne first parameter (matrix).
     * @param twoDimensionalMassiveTwo second parameter.
     * @return boolean value.
     */
    public boolean checkEqualsRowsColumnsMatrices(Matrix matrixOne,
                                                  Matrix twoDimensionalMassiveTwo) {
        return matrixOne.getNumberRows() == twoDimensionalMassiveTwo.getNumberColumns() &&
                matrixOne.getNumberColumns()==twoDimensionalMassiveTwo.getNumberColumns();
    }

    /**
     * Checking parameters for limit values.
     * @param row number of lines.
     * @param column number of columns.
     * @param matrix current matrix.
     * @return boolean value
     */
    public boolean checkValidValues(int row, int column, Matrix matrix) {
        return row >= 0 && row < matrix.getNumberRows()
                && column >= 0 && column < matrix.getNumberColumns();
    }

    /**
     * Is the object empty?
     * @param matrix - massive for check.
     * @return boolean
     */
    public boolean checkIsEmptyMatrix(Matrix matrix) {

        T [][] empty = (T[][]) matrix.getMatrix();
        return empty != null || empty.length != 0 || empty[0].length != 0;
    }

    public boolean checkIsEmptyMassive(Massive massive) {
        T []empty = (T[]) massive.getMassive();
        return (T[]) massive.getMassive() != null & empty.length > 1;
    }
}
