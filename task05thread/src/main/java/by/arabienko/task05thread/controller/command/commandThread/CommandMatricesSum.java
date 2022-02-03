package by.arabienko.task05thread.controller.command.commandThread;

import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.controller.command.CommandThread;
import by.arabienko.task05thread.service.threadImpl.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class CommandMatricesSum implements CommandThread {
    @Override
    public void execute() {
        ExecutorService ex = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(2);
        List<Future<List>> listFuture = new ArrayList<>();
        listFuture.add(ex.submit(new
                CommonResourceReadFromFile(lock, "date1")));
        listFuture.add(ex.submit(new
                CommonResourceReadFromFile(lock, "date2")));
        try {
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Matrix> future1;
            future1 = ex.submit(
                    new CreateMatrixInStreams(listFuture.get(0).get(),
                            "THREAD_CREATE_MATRIX-", latch));
            Future<Matrix> future2;
            future2 = ex.submit(
                    new CreateMatrixInStreams(listFuture.get(1).get(),
                            "THREAD_CREATE_MATRIX-", latch));
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Matrix> result;
            result = ex.submit(new MatricesSum(future1.get(),
                    future2.get(),lock, "SumThread-"));
            TimeUnit.MILLISECONDS.sleep(100);
            List list1 = new ArrayList();
            list1.add(result.get());
            ex.submit(new CommonResourceWriteToFile("save_matrix",
                    semaphore, list1, "WriteThread-"));
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException | IOException | ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
    }
}
