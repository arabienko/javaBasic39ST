package damothread.ex01thread;

public class HelloWorldRunnable implements Runnable{
    private String name;

    public HelloWorldRunnable(String name) {
        super();
        this.name = name;
    }


    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println(i+" runnable.. "+getName());
        }


    }

    public String getName() {
        return name;
    }
}
