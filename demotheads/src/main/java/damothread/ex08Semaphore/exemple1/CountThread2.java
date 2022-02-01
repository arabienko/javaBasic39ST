package damothread.ex08Semaphore.exemple1;

public class CountThread2 implements Runnable {
    CommonResource res;

    CountThread2 (CommonResource res) {
        this.res = res;
    }

    @Override
    public void run() {
       // res.increments();

    }
}
