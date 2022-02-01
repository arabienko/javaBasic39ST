package by.arabienko.task05thread.controller;

import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.bean.impl.Matrix;
import by.arabienko.task05thread.service.threadImpl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

    /**
     * Define a static logger variable.
     */
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    /**
     * Run program.
     *
     * @param args start
     */
    public static void main(final String[] args) throws ExecutionException, InterruptedException {


        ExecutorService ex = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();
        Semaphore semaphore = new Semaphore(1);
        CountDownLatch latch = new CountDownLatch(2);
        List list = new ArrayList();
        list.add("date3");
        for (int i = 0; i < 3; i++){
            Future<List> listFuture1 = ex.submit(new CommonResourceReadFromFile(lock, "date3"));
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Massive> future1 = ex.submit(
                    new CreateArrayInStreams(listFuture1.get(),lock,
                            "THREAD_CREATE_MATRIX-" + i));
            Future<Massive> result = ex.submit(new SortMergeArray(future1.get()
                    , lock,"SubtractThread-" + i));
            List list1 = new ArrayList();
            list1.add(result.get());
            try {
                ex.submit(new CommonResourceWriteToFile("save_massive",
                        semaphore, list1, "WriteThread-"+i));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       /* for (int i = 0; i < 3; i++) {
            Future<List> listFuture1 = ex.submit(new CommonResourceReadFromFile(lock, "date1"));
            Future<List> listFuture2 = ex.submit(new CommonResourceReadFromFile(lock, "date2"));
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Matrix> future1 = ex.submit(
                    new CreateMatrixInStreams(listFuture1.get(),
                            "THREAD_CREATE_MATRIX-" + i, latch));
            Future<Matrix> future2 = ex.submit(
                    new CreateMatrixInStreams(listFuture2.get(),
                            "THREAD_CREATE_MATRIX-" + i, latch));
            TimeUnit.MILLISECONDS.sleep(100);
            Future<Matrix> result = ex.submit(new MatricesSubstraction(future1.get(),
                    future2.get(), lock,"SubtractThread-" + i));
            TimeUnit.MILLISECONDS.sleep(100);

            List list1 = new ArrayList();
            list1.add(result.get());
            try {
                ex.submit(new CommonResourceWriteToFile("save_matrix",
                        semaphore, list1, "WriteThread-"+i));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
      /*  for (Future future : listFuture) {
            System.out.println(future.get());
        }*/
      /*  ArrayList<Future<String>> listFuture = new ArrayList<>();

        Integer[] mas = {2, 10, -5, 20, 8, 90, -1, 0, 0, 0, 0};
        Massive<Integer> massive = new Massive<>(mas);
        ArrayList<Future<List>> listFuture1 = new ArrayList<>();
        List list1 = new ArrayList();*/

        // String str = (listFuture.get(0)).get();
        // System.out.println("str " + str.length());
        // String[] numSTR = str.toString().trim().split(" ");
        //  Number num[] = new Number[numSTR.length];
        //  for (int i = 0; i < numSTR.length; i++) {
        //      num[i] = Integer.parseInt(numSTR[i]);
        //  };
    /*    Massive massive1 = new Massive();
        massive1.setMassive(mas);
        list1.add(massive1);
        for (int i = 0; i < 4; i++) {
            try {
                ex.submit(new CommonResourceWriteToFile("save_massive",
                        lock, list1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (Future list3 : listFuture) {
            try {
                System.out.println((list3.get()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        Integer[][] mas1 = {{2, 10, -5}, {20, 8, 90}, {-1, 0, 0}};
        Matrix<Integer> massive2 = new Matrix<>(mas1);

        for (int i = 0; i < 2; i++) {
            Matrix matrix = ThreadsCreatorForSum.operationSum
                    (massive2, massive2, "Thread sum-" + i);
            System.out.println(matrix);
        }
        *//*List strings = new ArrayList<>(Collections.singleton("1 2 5 8 9 -10 5 6"));
        Massive massive3 = null;
        for (int i = 0; i < 3; i++) {
            Future<Massive> future = ex.submit(new ThreadsCreateArray(strings, lock, "thread create array-"+i));
            massive3 = future.get();
            System.out.println(massive3);
        }*//*
        List strings = new ArrayList<>();
        strings.add("1 2 5 8 9 -10 5 6");
        strings.add("1 2 5 8 9 -10 5 6");
        Matrix matrix;
        for (int i = 0; i < 2; i++) {
            Future<Matrix> future = ex.submit(
                    new ThreadCreateMatrix(strings,
                            "THREAD_CREATE_MATRIX-"+i));
            matrix = future.get();
            System.out.println(matrix);
        }
*/

        ex.shutdown();
    }
}



