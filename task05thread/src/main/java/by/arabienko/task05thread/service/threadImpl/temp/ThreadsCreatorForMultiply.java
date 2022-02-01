package by.arabienko.task05thread.service.threadImpl.temp;

import by.arabienko.task05thread.bean.BeanException;
import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.impl.MatrixMultiplyImpl;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsCreatorForMultiply {
    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(MatrixMultiplyImpl.class);

    public static Matrix operationMultiply(Matrix matrixOne,
                                           Matrix matrixTwo, String nameThread) {
        Validation validation = new Validation();
        Future<Matrix> future = null;
        Matrix matrix;
        Matrix result = null;
        ReentrantLock l = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            if (validation.checkEqualsRowsColumnsMatrices
                    (matrixOne, matrixTwo)
                    & validation.checkIsEmptyMatrix(matrixOne)
                    & validation.checkIsEmptyMatrix(matrixTwo)) {
                matrix = new Matrix(matrixOne.getNumberRows(),
                        matrixOne.getNumberRows());
                future = service.submit(
                        new MatricesMultiplication(
                                matrixOne, matrixTwo,
                                matrix, l, nameThread));
            } else {
                LOGGER.debug
                        ("Operation multiply on matrices is not possible!");
                throw new ServiceException
                        ("Operation multiply on matrices is not possible!");
            }
            TimeUnit.MILLISECONDS.sleep(100);
            result = future.get();
        } catch (ServiceException | BeanException |
                ExecutionException | InterruptedException e) {
            LOGGER.debug
                    ("Stream operation error.");
            e.printStackTrace();
        }
        service.shutdown();
        return result;
    }
}
