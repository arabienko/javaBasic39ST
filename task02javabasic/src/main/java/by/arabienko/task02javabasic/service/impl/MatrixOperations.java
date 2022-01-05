package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.BeanException;
import by.arabienko.task02javabasic.bean.impl.Matrix;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Matrix operations.
 */
public class MatrixOperations {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ExchangeSortMassiveImpl.class);

    /**
     * Sum two matrix.
     *
     * @param matrixOne first two-dimensional matrix.
     * @param matrixTwo second two-dimensional matrix.
     * @return new matrix
     * @throws ServiceException throw exception when two matrices
     *                          cannot be summed up.
     */

    public Matrix matrixSum(Matrix matrixOne,
                            Matrix matrixTwo)
            throws ServiceException, BeanException {

        Matrix newMatrix;
        Validation validation = new Validation();

        if (validation.checkEqualsRowsColumnsMatrices
                (matrixOne, matrixTwo)) {

            newMatrix = new Matrix(matrixOne.getNumberRows(),
                    matrixOne.getNumberColumns());

            for (int i = 0; i < matrixOne.getNumberRows(); i++) {
                for (int j = 0; j < matrixOne.getNumberColumns(); j++) {
                    Number value = matrixOne.getElement(i, j).doubleValue() +
                            matrixTwo.getElement(i, j).doubleValue();
                    newMatrix.setElement(i, j, value);
                }
            }
        } else {
            LOGGER.debug("Operation on matrices is not possible!");
            throw new ServiceException("Operation on matrices is not possible!");
        }

        LOGGER.debug("Sum matrix completed");

        return newMatrix;
    }

    /**
     * Subtraction two matrix.
     *
     * @param matrixOne first two-dimensional matrix.
     * @param matrixTwo second two-dimensional matrix.
     * @return new matrix
     * @throws ServiceException throw exception when two matrices
     *                          cannot be subtracted up.
     */
    public Matrix matrixSubtraction(Matrix matrixOne,
                                    Matrix matrixTwo)
            throws ServiceException, BeanException {

        Matrix newMatrix;
        Validation validation = new Validation();

        if (validation.checkEqualsRowsColumnsMatrices
                (matrixOne, matrixTwo)) {
            newMatrix = new Matrix(matrixOne.getNumberRows(),
                    matrixOne.getNumberColumns());
            for (int i = 0; i < matrixOne.getNumberRows(); i++) {
                for (int j = 0; j < matrixOne.getNumberColumns(); j++) {
                    double value = matrixOne.getElement(i, j).doubleValue() -
                            matrixTwo.getElement(i, j).doubleValue();
                    newMatrix.setElement(i, j, value);
                }
            }

        } else {
            throw new ServiceException("Operation on matrices is not possible!");
        }

        return newMatrix;
    }

    /**
     * Multiply two matrix.
     *
     * @param matrixOne first two-dimensional matrix.
     * @param matrixTwo second two-dimensional matrix.
     * @return new matrix
     * @throws ServiceException throw exception when two matrices
     *                          cannot be multiplied up.
     */
    public Matrix matrixMultiply(Matrix matrixOne,
                                 Matrix matrixTwo)
            throws ServiceException, BeanException {

        Matrix newMatrix;
        Validation validation = new Validation();

        if (validation.checkEqualsRowsColumnsMatrices
                (matrixOne, matrixTwo) &
                validation.checkIsEmptyMatrix(matrixOne) &
                validation.checkIsEmptyMatrix(matrixTwo)) {
            newMatrix = new Matrix(matrixOne.getNumberRows(),
                    matrixOne.getNumberColumns());
            for (int i = 0; i < matrixOne.getNumberRows(); i++) {
                for (int j = 0; j < matrixOne.getNumberColumns(); j++) {
                    double value = matrixOne.getElement(i, j).doubleValue() *
                            matrixTwo.getElement(i, j).doubleValue();
                    newMatrix.setElement(i, j, value);
                }
            }

        } else {
            throw new ServiceException("Operation on matrices is not possible!");
        }

        return newMatrix;
    }

    /**
     * Multiply matrix and number.
     *
     * @param matrix two-dimensional matrix - first multiplier.
     * @param number - second multiplier.
     * @return new matrix
     * @throws ServiceException throw exception when two matrices
     *                          cannot be multiplied up.
     */
    public Matrix matrixMultiplyNumber(Matrix matrix,
                                       double number) throws ServiceException, BeanException {

        Matrix newMatrix = null;
        Validation validation = new Validation();

        if (validation.checkIsEmptyMatrix(matrix)) {
            newMatrix = new Matrix(matrix.getNumberRows(),
                    matrix.getNumberColumns());
            for (int i = 0; i < matrix.getNumberRows(); i++) {
                for (int j = 0; j < matrix.getNumberColumns(); j++) {
                    double value = matrix.getElement(i, j).doubleValue() * number;
                    newMatrix.setElement(i, j, value);
                }
            }
        }
        return newMatrix;
    }

}
