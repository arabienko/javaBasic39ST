package damothread.ex02isActiveThread;

public class RunnerThreadToDisable {
    public static void main(String[] args) {
        System.out.println("Главный поток начал работу...");
        ThreadToDisable threadToDisable = new ThreadToDisable();
        Thread thread = new Thread(threadToDisable,"name of ThreadToDisable");

        thread.start();

        try {
            Thread.sleep(110);
            threadToDisable.disable();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }
        System.out.println("Главный поток завершил работу...");
    }
}
