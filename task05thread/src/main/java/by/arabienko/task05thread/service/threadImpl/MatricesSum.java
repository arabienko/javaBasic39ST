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
 * The class of finding
 * the sum of two matrices.
 * ReentrantLock.
 */
public class MatricesSum implements Callable<Matrix>, IThread {
    private static final Logger LOGGER
            = LogManager.getLogger(MatricesSum.class);
    private Matrix matrixFirst;
    private Matrix matrixSecond;
    private String nameThread;
    private ReentrantLock lock;


    public MatricesSum(Matrix matrixFirst,
                       Matrix matrixSecond,
                       ReentrantLock l,
                       String nameThread) {
        this.matrixFirst = matrixFirst;
        this.matrixSecond = matrixSecond;
        this.nameThread = nameThread;
        this.lock = l;
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Matrix call() throws Exception {
        Validation validation = new Validation();
        Matrix newMatrix;
        Number[][] newNum;
        LOGGER.debug("thread "
                + this.getNameThread() + " started sum...");
        lock.lock();
        if (validation.checkEqualsRowsColumnsMatrices
                (matrixFirst, matrixSecond) &
                validation.checkIsEmptyMatrix(matrixFirst) &
                validation.checkIsEmptyMatrix(matrixSecond)) {
            newNum =
                    new Number[matrixFirst.getNumberRows()][];
            Phaser phaser = new Phaser(1);
            List<Future<Number[]>> futureList = new ArrayList<>();
            ExecutorService pool =
                    Executors.newFixedThreadPool(10);
            for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
                futureList.add(pool.submit(
                        new SumRows(matrixFirst.getMatrix()[i],
                                matrixSecond.getMatrix()[i], phaser)));
            }
            phaser.arriveAndDeregister();
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
                + getNameThread() + " finished sum...");
        LOGGER.debug("thread "
                + getNameThread() + " result sum= " + newMatrix);
        return newMatrix;
    }
}
