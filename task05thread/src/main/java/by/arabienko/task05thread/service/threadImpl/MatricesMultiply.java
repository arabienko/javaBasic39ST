package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.IThread;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
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
        Number[][] newNum;
        if (validation.checkEqualsRowsColumnsMatrices
                (matrixFirst, matrixSecond) &
                validation.checkIsEmptyMatrix(matrixFirst) &
                validation.checkIsEmptyMatrix(matrixSecond)) {
            newNum =
                    new Number[matrixFirst.getNumberRows()][];
            CountDownLatch downLatch =
                    new CountDownLatch(matrixFirst.getNumberRows());
            List<Future<Number[]>> futureList = new ArrayList<>();
            ExecutorService pool =
                    Executors.newFixedThreadPool(10);
            for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
                futureList.add(pool.submit(
                        new MultiplyRows(matrixFirst.getMatrix()[i],
                                matrixSecond.getMatrix()[i], downLatch)));
            }
            countDown.await();
            for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
                newNum[i] = futureList.get(i).get();
            }
            pool.shutdown();
            newMatrix = new Matrix(newNum);
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
