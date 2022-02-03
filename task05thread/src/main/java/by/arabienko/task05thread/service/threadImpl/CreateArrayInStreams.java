package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.IThread;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class for creating
 * an Array in a stream
 * from a string stored
 * in a list.
 * Implemented with ReentrantLock.
 */
public class CreateArrayInStreams implements Callable<Massive>, IThread {
    private static final Logger LOGGER =
            LogManager.getLogger(CreateArrayInStreams.class);

    private List list;
    private ReentrantLock lock;
    private String nameThread;

    public CreateArrayInStreams(List list,
                                ReentrantLock lock,
                                String nameThread) {
        this.list = list;
        this.lock = lock;
        this.nameThread = nameThread;
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public Massive call() throws Exception {
        LOGGER.debug("thread "
                + this.getNameThread()
                + " started create array...");
        lock.lock();
        String[] word = ((String) list.get(0))
                .trim().split(" ");
        Number[] numb = new Number[word.length];
        for (int j = 0; j < word.length; j++) {
            numb[j] = Integer.parseInt(word[j]);
        }
        Massive resultArray = new Massive(numb);
        TimeUnit.MILLISECONDS.sleep(100);
        lock.unlock();
        LOGGER.debug("thread "
                + this.nameThread
                + " result array= " + resultArray);
        return resultArray;
    }
}
