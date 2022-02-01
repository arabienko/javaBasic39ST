package damothread.ex17deadlock;

import java.util.concurrent.BrokenBarrierException;

public class DeadlockMain {
    public static void main(String[] args) {
        //CyclicBarrier s = new CyclicBarrier(2);
        InviteAction invite1 = new InviteAction("first");
        InviteAction invite2 = new InviteAction("second");
        InviteAction invite3 = new InviteAction("third");
        new Thread(() -> {
            try {
                invite1.invite(invite2);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                invite2.invite(invite1);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                invite3.invite(invite2);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                invite3.invite(invite1);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                invite1.invite(invite3);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                invite2.invite(invite1);
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
