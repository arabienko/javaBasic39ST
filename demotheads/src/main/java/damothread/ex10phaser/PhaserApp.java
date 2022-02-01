package damothread.ex10phaser;

import java.util.concurrent.Phaser;

public class PhaserApp {
    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        //phaser.register();
        new Thread(new PhaseThread(phaser,
                "PhaseThread 1")).start();
        new Thread(new PhaseThread(phaser,
                "PhaseThread 2")).start();

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        // ждем завершения фазы 2
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");

        phaser.arriveAndDeregister();
    }
}
