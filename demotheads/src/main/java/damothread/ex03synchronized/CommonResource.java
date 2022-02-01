package damothread.ex03synchronized;

public class CommonResource {
    int x;

    synchronized public void increments() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), i);
            x++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
