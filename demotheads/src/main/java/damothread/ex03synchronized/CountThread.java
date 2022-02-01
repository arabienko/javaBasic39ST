package damothread.ex03synchronized;

public class CountThread implements  Runnable{
    CommonResource commonResource;
    public CountThread(CommonResource commonResource) {
    this.commonResource = commonResource;
    }


    @Override
    public void run() {
        synchronized (commonResource) {
            commonResource.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), commonResource.x);
                commonResource.x++;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
