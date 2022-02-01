package damothread.ex13Callable;

import java.util.concurrent.*;

public class CalcRunner {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Future<Number>numberFuture = ex.submit(new CalcCallable());
        ex.shutdown();
        try {
            System.out.println(numberFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
