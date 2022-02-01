package damothread.ex08Semaphore.exemple2;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    Semaphore semaphore;
    int num  = 0;
    int id;
    public Philosopher(Semaphore semaphore, int id) {
        this.semaphore = semaphore;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3)// пока количество приемов пищи не достигнет 3
            {
                // Запрашиваем у семафора разрешение на выполнение
                semaphore.acquire();
                System.out.println("Философ " + id + " садится за стол");
                // философ ест
                sleep(500);
                num++;

                System.out.println("Философ " + id + " выходит из-за стола");
                semaphore.release();

                // философ гуляет
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " проблемы со здоровьем");
        }
    }

}
