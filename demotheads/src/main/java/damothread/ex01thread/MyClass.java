package damothread.ex01thread;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyClass {
    private static final Logger LOGGER = LogManager.
            getLogger(HelloWorld.class);

    public static void main(String[] args) {

        HelloWorld helloWorld1 = new HelloWorld("helloWorld1");
    //    System.out.println("thread 1 " + helloWorld1.getState());

        LOGGER.info("thread1 helloWorld1" + helloWorld1.getMyName());

        HelloWorld helloWorld2 = new HelloWorld("helloWorld2");
      //  System.out.println("thread2 helloWorld2 " + helloWorld1.getState());
/*
        HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable("Runnable-1");
        System.out.println("Start runnable-1");
        new Thread(helloWorldRunnable).start();

        HelloWorldRunnable helloWorldRunnable1 = new HelloWorldRunnable("Runnable-2");
        System.out.println("Start runnable-2");
        Thread thread = new Thread(helloWorldRunnable1);
        thread.start();
        System.out.println("Thread.currentThread(); " + Thread.currentThread().getName());*/
        //Thread.currentThread();

        helloWorld2.start();
      /*  if (helloWorld2.isAlive()) {
            System.out.println("helloWorld2 /////" + helloWorld2.getState());
        }*/
        helloWorld1.start();
       // System.out.println("thread 2 " + helloWorld2.getState());
        LOGGER.info("thread1 " + helloWorld1.getMyName());
      //  helloWorld1.setPriority(Thread.NORM_PRIORITY);
      //  helloWorld2.setPriority(Thread.MIN_PRIORITY);
    }
}
