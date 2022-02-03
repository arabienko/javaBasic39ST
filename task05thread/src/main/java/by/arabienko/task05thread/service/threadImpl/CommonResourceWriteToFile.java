package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.IThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The class for writing a matrix
 * or array to a text file.
 * The recording process is
 * implemented in
 * a separate thread
 * using Semaphore.
 */
public class CommonResourceWriteToFile implements Runnable, Closeable, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(CommonResourceWriteToFile.class);

    private FileWriter fileWriter;
    Semaphore semaphore;
    private List list;
    private String nameThread;

    public CommonResourceWriteToFile(String file,
                                     Semaphore semaphore,
                                     List list, String name)
            throws IOException {
        Path path = Paths.
                get("src/main/resources/save_package");
        Path fileToCreatePath =
                path.resolve(file);
        String newFileName =
                fileToCreatePath.toString();
        fileWriter =
                new FileWriter(newFileName, true);
        this.semaphore = semaphore;
        this.list = list;
        this.nameThread = name;
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public void run() {
        if (list.get(0) instanceof Massive) {
            try {
                semaphore.acquire();
                LOGGER.debug("Start writing to file - "
                        + getNameThread());

                Massive massive1 = (Massive) list.get(0);
                Number[] massive = massive1.getMassive();
                StringBuffer stringBuilder = new StringBuffer();
                for (Number rows : massive) {
                    stringBuilder.append(rows).append(" ");
                }
                stringBuilder.append("\n");
                fileWriter.append(String.valueOf(stringBuilder));
                fileWriter.close();
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        } else {
            try {
                semaphore.acquire();
                LOGGER.debug("Start writing to file - "
                        + getNameThread());
                Matrix massiveImpl = (Matrix) list.get(0);
                Number[][] matrix = massiveImpl.getMatrix();
                StringBuilder stringBuilder = new StringBuilder();
                for (Number[] numbers : matrix) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        stringBuilder.append(numbers[j]).append(" ");
                    }
                    stringBuilder.append("\n");
                }
                stringBuilder.append("\n");
                fileWriter.write(String.valueOf(stringBuilder));
                fileWriter.close();
            } catch (IOException | InterruptedException e) {
                System.err.print(e);
            } finally {
                semaphore.release();
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (fileWriter!=null) {
            fileWriter.close();
        }
    }

}
