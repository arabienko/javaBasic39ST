package damothread.ex03synchronized;

public class ThreadsApp {
    public static void main(String[] args) {
        CommonResource commonResource = new CommonResource();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new CountThread(commonResource));
            thread.setName("Thread "+i);
            thread.start();
        }

        for (int i = 0; i < 6; i++) {
            Thread thread2 = new Thread(new CountThread2(commonResource));
            thread2.setName("Thread2 "+i);
            thread2.start();
        }

    }
}
