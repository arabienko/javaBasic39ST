package damothread.ex02isActiveThread;

public class ThreadToDisable implements Runnable {
    private boolean isActive;

    public ThreadToDisable() {
        this.isActive = true;
    }

    void disable() {
        isActive = false;
    }

    @Override
    public void run() {
        System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
        int count = 1;
        while (isActive) {
            System.out.println("Цикл " + count++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Поток %s завершил работу... \n", Thread.currentThread().getName());

    }
}
