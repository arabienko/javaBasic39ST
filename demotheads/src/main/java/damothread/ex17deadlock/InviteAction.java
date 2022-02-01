package damothread.ex17deadlock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class InviteAction {
    private String name;
    CyclicBarrier barrier;

    public InviteAction(String name) {
        this.name = name;
        this.barrier = new CyclicBarrier(1, ()-> InviteAction.this.action());


    }

    public synchronized void invite(InviteAction obj) throws BrokenBarrierException, InterruptedException {

        System.out.println(name + " invites " + obj.name.toUpperCase());
        Thread.sleep(1000);
        //System.out.println(barrier.getNumberWaiting());
        this.barrier.await();
        //obj.action(); // deadlock

    }

    public synchronized void action(){
        System.out.println(name + " action");
    }
}
