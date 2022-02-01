package damothread.ex09exchange;

import java.util.concurrent.Exchanger;

public class ExchangerApp {
    private static int n = 2;

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        for (int i = 0; i < n; i++) {
            Thread thread = new Thread(new PutThread(exchanger));
            Thread thread1 = new Thread(new GetThread(exchanger));
            thread.setName("Поток Put " + i);
            thread1.setName("Поток Get " + i);

            thread.start();
            thread1.start();

        }

    }
}
