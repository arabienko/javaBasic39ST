package damothread.ex01thread;

public class JoinThread extends Thread {
    private String name;

    public JoinThread(String name) {
        super(name);
        this.name = name;
    }

    public void run() {
        String nameThread = getName();
        long timeOut = 0;
        System.out.println("Старт потока " + nameThread);
        try {
            switch (nameThread) {
                case "First":
                    timeOut = 5_000;
                    break;
                case "Second":
                    timeOut = 1_000;
                    break;
            }
            Thread.sleep(timeOut);
            System.out.println("завершение потока " + nameThread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
