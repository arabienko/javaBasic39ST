package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.IThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.*;

import static java.lang.Integer.parseInt;

/**
 * A class for creating
 * a Matrix in a stream
 * from strings stored
 * in a List.
 * Row and column numbers
 * are stored in separate collections.
 * The matrix is filled in by numbers
 * from the collections CopyOnWriteArrayList.
 */
public class CreateMatrixInStreams implements Callable<Matrix>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(CreateMatrixInStreams.class);

    private List list;
    private String nameThread;
    CountDownLatch downLatch;
    private CopyOnWriteArrayList<Integer> rowsStore =
            new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<Integer> columnStore =
            new CopyOnWriteArrayList<>();

    public CreateMatrixInStreams(List list,
                                 String nameThread,
                                 CountDownLatch latch) {
        this.list = list;
        this.nameThread = nameThread;
        this.downLatch = latch;
        //filling collections with numbers of columns and rows for a matrix.
        for (int i = 0; i < list.size(); i++) {
            rowsStore.add(i);
        }
        int numColumn = list.get(0).toString()
                .trim().split(" ").length;
        for (int i = 0; i < numColumn; i++) {
            columnStore.add(i);
        }
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }
    @Override
    public Matrix call() throws Exception {
        LOGGER.debug("start creation matrix from thread: "
                + getNameThread());
        CopyOnWriteArrayList
                copy = new CopyOnWriteArrayList<>(list);
        CopyOnWriteArrayList<Number[]>
                newMatrix = new CopyOnWriteArrayList<>();
        for (Integer integer : rowsStore) {
            String[] word = copy.get(integer).toString()
                    .trim().split(" ");
            Number[] numb =
                    new Number[word.length];
            for (Integer column : columnStore) {
                numb[column] = parseInt(word[column]);
            }
            newMatrix.add(numb);
        }
        Number[][] matrixFromMassive =
                new Number[rowsStore.size()][columnStore.size()];
        for (Integer integer : rowsStore) {
            matrixFromMassive[integer] =
                    newMatrix.get(integer);
        }
        TimeUnit.MILLISECONDS.sleep(100);
        Matrix matrix =
                new Matrix(matrixFromMassive);
        LOGGER.debug(getNameThread()
                + " thread finished to create matrix: "
                + matrix);
        downLatch.countDown();
        return matrix;
    }

}
