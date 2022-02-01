package damothread.ex14StringBuilder;

public class NewThreadBuffer {
    static int counter = 0;
   static StringBuffer s = new StringBuffer();
   // static StringBuilder s = new StringBuilder();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (s) {
                while (NewThreadBuffer.counter++ < 5) {
                    s.append("ATV");
                    System.out.print("> " + counter + " ");
                    System.out.println(s);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } // конец synchronized-блока
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (NewThreadBuffer.counter++ < 6) {
            System.out.print("< " + counter + " ");
// в этом месте поток main будет ждать освобождения блокировки объекта s
            s.append("XBB");
            System.out.println(s);
        }
    }
}
