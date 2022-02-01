package damothread.ex09exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetThread implements Runnable {
    Exchanger<String> exchanger;
    String message;

    GetThread(Exchanger exchanger){

        this.exchanger=exchanger;
        message = "Привет мир!";
    }


    @Override
    public void run() {
        try{
            message += " - It is the message from GetThread (" + Thread.currentThread().getName() + ")";
            message=exchanger.exchange(message,5, TimeUnit.MILLISECONDS);
            System.out.println("GetThread " + Thread.currentThread().getName() + " получил: " + message);
        }
        catch(InterruptedException | TimeoutException ex){
            System.out.println(ex.getMessage());
        }


    }
}
