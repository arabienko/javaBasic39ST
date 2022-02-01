package damothread.ex14StringBuilder;

public class TwoThread {
    public static int count = 0;

    public static void main(String[] args) {
        //final StringBuilder sb = new StringBuilder();
        final StringBuffer sb = new StringBuffer();

        new Thread(() -> {
            synchronized (sb){
                do {
                    sb.append("ATV");
                    System.out.println(sb);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }while (count++<2);
            }
        }).start();

        new Thread(() -> {
            synchronized (sb){
                do {
                    sb.append("XBB");
                    System.out.println(sb);

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }while (count++<6);
            }
        }).start();
    }
}
