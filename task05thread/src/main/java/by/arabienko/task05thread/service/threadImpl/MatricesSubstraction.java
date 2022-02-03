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
 * A class for finding the subtraction
 * of one matrix from another.
 * The result is a new matrix.
 * Row subtraction is performed
 * in separate threads with a cyclic barrier
 * equal to the number of matrix rows.
 * When approaching the barrier
 * of all executed string subtraction
 * threads, the program proceeds further:
 * the new matrix is filled
 * with strings from the threads.
 */
public class MatricesSubstraction implements Callable<Matrix>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(MatricesSubstraction.class);

    private Matrix matrixFirst;
    private Matrix matrixSecond;
    private String nameThread;
    private ReentrantLock lock;
    CyclicBarrier cyclicBarrier;

    public MatricesSubstraction(Matrix matrixFirst,
                                Matrix matrixSecond,
                                ReentrantLock l,
                                String nameThread) {
        this.matrixFirst = matrixFirst;
        this.matrixSecond = matrixSecond;
        this.nameThread = nameThread;
        this.lock = l;
        this.cyclicBarrier =
                new CyclicBarrier(matrixFirst.getNumberRows());
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Matrix call() throws Exception {
        //lock.lock();
        Validation validation = new Validation();
        Matrix newMatrix;
        Number[][] newNum;
        LOGGER.debug("thread "
                + this.getNameThread() + " started substraction...");
        if (validation.checkEqualsRowsColumnsMatrices
                (matrixFirst, matrixSecond) &
                validation.checkIsEmptyMatrix(matrixFirst) &
                validation.checkIsEmptyMatrix(matrixSecond)) {
            newNum =
                    new Number[matrixFirst.getNumberRows()][];
            ExecutorService ex =
                    Executors.newFixedThreadPool(10);
            List<Future<Number[]>> futureList = new ArrayList<>();
            for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
                futureList.add(ex.submit(
                        new SubstractionRows(matrixFirst.getMatrix()[i],
                        matrixSecond.getMatrix()[i], cyclicBarrier)));
            }
            for (int i = 0; i < futureList.size(); i++) {
                newNum[i] = futureList.get(i).get();
            }
            ex.shutdown();
            newMatrix = new Matrix(newNum);
        } else {
            LOGGER.debug("Operation on matrices is not possible!");
            throw new ServiceException("Operation on matrices is not possible!");
        }
        TimeUnit.MILLISECONDS.sleep(100);

        //lock.unlock();
        LOGGER.debug("thread "
                + getNameThread() + " finished substraction, " +
                "result Substraction: " +newMatrix);
        return newMatrix;
    }

}
