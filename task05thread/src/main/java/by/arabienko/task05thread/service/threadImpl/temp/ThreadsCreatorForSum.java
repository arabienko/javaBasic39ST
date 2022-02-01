package by.arabienko.task05thread.service.threadImpl.temp;

import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.threadImpl.MatricesSum;
import by.arabienko.task05thread.service.Validation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsCreatorForSum {
    /**
     * Logging events.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(ThreadsCreatorForSum.class);

    public static Matrix operationSum(Matrix matrixOne,
                                      Matrix matrixTwo, String nameThread){
        Validation validation = new Validation();
        Future<Matrix> future;
        Matrix result = null;
        ReentrantLock l = new ReentrantLock();
        ExecutorService service = Executors.newCachedThreadPool();
        try {
                future = service.submit(
                        new MatricesSum(
                                matrixOne, matrixTwo,l,
                                nameThread));

            TimeUnit.MILLISECONDS.sleep(100);
            result = future.get();
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.debug
                    ("Stream operation error.");
            e.printStackTrace();
        }
        service.shutdown();
        return result;
    }
}
