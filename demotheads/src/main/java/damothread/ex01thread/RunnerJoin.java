package damothread.ex01thread;

public class RunnerJoin {
    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread("First");
        JoinThread joinThread1 = new JoinThread("Second");
        joinThread.start();
        joinThread1.start();

        try {
            joinThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
