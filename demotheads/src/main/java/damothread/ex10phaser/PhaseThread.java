package damothread.ex10phaser;

import java.util.concurrent.Phaser;

public class PhaseThread implements Runnable {
    Phaser phaser;
    String name;

    PhaseThread(Phaser p, String n) {
        this.phaser = p;
        this.name = n;
        phaser.register();
    }


    @Override
    public void run() {
        System.out.println(name + " выполняет фазу " + phaser.getPhase()+" "+Thread.currentThread());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndAwaitAdvance(); // сообщаем, что вторая фаза достигнута
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " выполняет фазу " + phaser.getPhase());
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
