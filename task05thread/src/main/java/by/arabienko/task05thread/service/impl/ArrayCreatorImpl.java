package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.bean.impl.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Class for creating matrices.
 */
public class ArrayCreatorImpl<T extends Number> {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ArrayCreatorImpl.class);


    /**
     * Creation two-dimensional matrix with int random parameters.
     *
     * @param matrix
     * @param minValue
     * @param maxValue
     * @return
     */
    public void setMatrixValueRandomInt(Matrix matrix,
                                        final int minValue, final int maxValue) {
        int numberOfRows = matrix.getNumberRows();
        int numberOfColumns = matrix.getNumberColumns();
        Random random = new Random();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                int value = (random.nextInt(50)
                        * (maxValue - minValue) + minValue);
                matrix.setElement(i, j, value);
            }
        }
    }

    /**
     * Creation two-dimensional matrix with double random parameters.
     *
     * @param minValue
     * @param maxValue
     * @return new matrix.
     */
    public void setMatrixValueRandomDouble(Matrix matrix, final int minValue, final int maxValue) {
        Random random = new Random();
        int numberOfRows = matrix.getNumberRows();
        int numberOfColumns = matrix.getNumberColumns();
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                double value = (random.nextDouble()
                        * (maxValue - minValue) + minValue);
                matrix.setElement(i, j, value);
            }
        }
    }

    public void setMassiveValueRandomDouble(Massive massive, final int minValue, final int maxValue) {
        Random random = new Random();

        for (int i = 0; i < massive.getMassive().length; i++) {
            double value = (random.nextDouble()
                    * (maxValue - minValue) + minValue);
            massive.setElement(i, value);

        }
    }

    public void setMassiveValueRandomInt(Massive massive, final int minValue, final int maxValue) {
        Random random = new Random();

        for (int i = 0; i < massive.getMassive().length; i++) {
            double value = (random.nextInt(50)
                    * (maxValue - minValue) + minValue);
            massive.setElement(i, value);

        }
    }
}