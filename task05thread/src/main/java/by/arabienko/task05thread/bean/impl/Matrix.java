package by.arabienko.task05thread.bean.impl;

import by.arabienko.task05thread.bean.ArrayInterface;
import by.arabienko.task05thread.bean.BeanException;
import by.arabienko.task05thread.service.ServiceException;

import java.util.Arrays;

/**
 * @param <T> parametric matrix class (extends of numbers).
 */
public class Matrix<T extends Number> implements ArrayInterface {

    private T[][] matrix;
    private static long counter = 0;
    private static long ID = counter++;
    public Matrix(T[][] matrix) {
        this.matrix = matrix;
    }
    public Matrix(int rows, int columns) throws ServiceException, BeanException {
        //
        if (rows < 1 || columns < 1) {
            //TODO: bean exception
            throw new BeanException("It is not possible to create an object!");
        }
        matrix = (T[][]) new Number[rows][columns];
    }
    public T[][] getMatrix() {
        //TODO: copy matrix, нет необходимости
        T[][] matrixCopy = matrix.clone();
       return matrixCopy;
    }
  /*  public void setMatrix(T[][] matrix) {
        //TODO : не нужно
        this.matrix = matrix;
    }*/
    public T getElement(int row, int column) throws BeanException {
        //TODO: validation
        if (row < 0 || column < 0) {
            //TODO: bean exception
            throw new BeanException("It is not possible to create an object!");
        }
        return matrix[row][column];
    }
    public int getNumberColumns() {
        return matrix[0].length;
    }
    public int getNumberRows() {
        return matrix.length;
    }
    public void setElement(int row, int column, T value) {
        matrix[row][column] = value;
    }

    /**
     * @return counting created objects.
     */
    public long id() {
        return ID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) return true;
        if (obj==null || this.getClass()!=obj.getClass()) return false;
        Matrix matrix1 = (Matrix) obj;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //TODO : Double.compare(), Arrays.deepEquals
                try {
                    if (Double.compare(matrix1.getElement(i, j).doubleValue(),
                            matrix[i][j].doubleValue())!=0) {
                        return false;
                    }
                } catch (BeanException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
    @Override
    public String toString() {
        final String SPACE = " ";
        StringBuilder stringBuilder = new StringBuilder("\nMatrix: "
                + matrix.length + " x " + matrix[0].length + "\n");
        for (T[] rows : matrix) {
            for (T value : rows) {
                stringBuilder.append(value).append(SPACE);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
