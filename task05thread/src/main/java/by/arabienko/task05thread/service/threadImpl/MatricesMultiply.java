package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Matrix multiplication class.
 * The result of which is a new matrix.
 * Matrix multiplication occurs
 * after a latch is fired,
 * when two matrices have been
 * read and created.
 */
public class MatricesMultiply implements Callable<Matrix>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(MatricesMultiply.class);

    private CountDownLatch countDown;
    private Matrix matrixFirst;
    private Matrix matrixSecond;
    private String nameThread;
    private ReentrantLock lock;

    public MatricesMultiply(CountDownLatch countDown,
                            Matrix matrixFirst, Matrix matrixSecond,
                            String nameThread, ReentrantLock lock) {
        this.countDown = countDown;
        this.matrixFirst = matrixFirst;
        this.matrixSecond = matrixSecond;
        this.nameThread = nameThread;
        this.lock = lock;
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Matrix call() throws Exception {
        Validation validation = new Validation();
        countDown.await();
        lock.lock();
        Matrix newMatrix;
        if (validation.checkEqualsRowsColumnsMatrices
                (matrixFirst, matrixSecond) &
                validation.checkIsEmptyMatrix(matrixFirst) &
                validation.checkIsEmptyMatrix(matrixSecond)) {
            newMatrix = new Matrix(matrixFirst.getNumberRows(),
                    matrixFirst.getNumberColumns());
            for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
                for (int j = 0; j < matrixFirst.getNumberColumns(); j++) {
                    double value = matrixFirst.getElement(i, j).doubleValue() *
                            matrixSecond.getElement(i, j).doubleValue();
                    newMatrix.setElement(i, j, value);
                }
            }

        } else {
            LOGGER.debug("Operation on matrices is not possible!");
            throw new ServiceException("Operation on matrices is not possible!");
        }
        TimeUnit.MILLISECONDS.sleep(100);
        lock.unlock();
        LOGGER.debug("thread "
                + getNameThread() + " finished multiply...");
        LOGGER.debug("thread "
                + getNameThread() + " result multiply= " + newMatrix);
        return newMatrix;
    }
}
