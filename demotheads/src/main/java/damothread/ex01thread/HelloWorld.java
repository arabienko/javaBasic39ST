package damothread.ex01thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HelloWorld extends Thread {
    private static final Logger LOGGER = LogManager.
            getLogger(HelloWorld.class);
    private String name;


    public HelloWorld(String name) {
        super(name);
        this.name = name;

    }

    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("MyThread... " + getName());

            if (!this.isInterrupted()) {
                System.out.println("interrupted "+getName()+" "+getState());
                this.interrupt();
                //Thread.sleep(1000);
                System.out.println("interrupted ");
            }

        }
    }

    public State getState() {
        return super.getState();
    }

    public String getMyName() {
        return name;
    }
}


