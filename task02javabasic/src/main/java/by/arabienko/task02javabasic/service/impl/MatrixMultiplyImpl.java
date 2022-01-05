package by.arabienko.task02javabasic.service.impl;

import by.arabienko.task02javabasic.bean.BeanException;
import by.arabienko.task02javabasic.bean.impl.Matrix;
import by.arabienko.task02javabasic.service.MatrixOperationService;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.view.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplyImpl implements MatrixOperationService {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(MatrixMultiplyImpl.class);


    /**
     * Multiply two matrix.
     *
     * @param list two matrices.
     * @return new matrix
     * @throws ServiceException throw exception when two matrices
     *                         cannot be multiplied up.
     */
    @Override
    public List matrixOperation(List list) throws ServiceException, BeanException {

        Matrix newMatrix;
        Validation validation = new Validation();
        Matrix matrixOne = (Matrix) list.get(0);
        Matrix matrixTwo = (Matrix) list.get(1);

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
            LOGGER.debug("Operation on matrices is not possible!");
            throw new ServiceException("Operation on matrices is not possible!");
        }

        List list1 = new ArrayList();
        list1.add(newMatrix);

        LOGGER.debug("Multiply matrix completed");

        return list1;
    }
}
