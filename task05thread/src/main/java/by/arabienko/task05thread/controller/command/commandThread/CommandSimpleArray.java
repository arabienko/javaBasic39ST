package by.arabienko.task05thread.controller.command.commandThread;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.controller.command.CommandThread;
import by.arabienko.task05thread.service.threadImpl.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CommandSimpleArray implements CommandThread {
    @Override
    public void execute() {
        ExecutorService ex = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(2);
        try {
            Future<List> listFuture1 =
                    ex.submit(new CommonResourceReadFromFile(
                            lock, "date3"));
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Massive> future1 = ex.submit(
                    new CreateArrayInStreams(listFuture1.get(),
                            lock,"THREAD_CREATE_MATRIX-"));
            Future<Massive> result = ex.submit(
                    new SortSimpleArray(future1.get(),
                            lock, "SimpleSortThread-"));
            List list1 = new ArrayList();
            list1.add(result.get());
            ex.submit(new CommonResourceWriteToFile("save_massive",
                    semaphore, list1, "WriteThread-"));
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException
                | IOException
                | ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
    }
}
