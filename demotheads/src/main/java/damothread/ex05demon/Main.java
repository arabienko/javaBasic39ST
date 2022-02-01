package damothread.ex05demon;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String ... args) {
        System.out.println("первый оператор main");
        SimpleThread usual = new SimpleThread();
        SimpleThread daemon = new SimpleThread();
        daemon.setDaemon(true);
        daemon.start();
        usual.start();

        try {
            TimeUnit.SECONDS.sleep(1); // заменить параметр на 1
        } catch (InterruptedException newE) {
            newE.printStackTrace();
        }
        System.out.println("последний оператор main");
    }
}
