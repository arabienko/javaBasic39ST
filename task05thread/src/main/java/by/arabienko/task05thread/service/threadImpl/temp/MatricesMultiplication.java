package by.arabienko.task05thread.service.threadImpl.temp;

import by.arabienko.task05thread.bean.impl.Matrix;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MatricesMultiplication implements Callable<Matrix> {
    private static final Logger LOGGER =
            LogManager.getLogger(MatricesMultiplication.class);
    private Matrix matrixFirst;
    private Matrix matrixSecond;
    private String nameThread;
    private Matrix result;
    private ReentrantLock lock;


    public MatricesMultiplication(Matrix matrixFirst,
                                  Matrix matrixSecond,
                                  Matrix result,
                                  ReentrantLock l,
                                  String nameThread) {
        this.matrixFirst = matrixFirst;
        this.matrixSecond = matrixSecond;
        this.nameThread = nameThread;
        this.result = result;
        this.lock = l;
    }

    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Matrix call() throws Exception {
        LOGGER.debug("thread "
                +this.getNameThread()+ " started Multiplication...");
        lock.lock();
        for (int i = 0; i < matrixFirst.getNumberRows(); i++) {
            for (int j = 0; j < matrixFirst.getNumberColumns(); j++) {
                double value = matrixFirst.getElement(i, j).doubleValue() *
                        matrixSecond.getElement(i, j).doubleValue();
                result.setElement(i, j, value);
            }
        }
        TimeUnit.MILLISECONDS.sleep(100);
        lock.unlock();
        LOGGER.debug("thread "+this.nameThread
                + " finished Multiplication...");
        LOGGER.debug("thread "+this.nameThread
                + " result Multiplication= "+result);
        return result;
    }
}
