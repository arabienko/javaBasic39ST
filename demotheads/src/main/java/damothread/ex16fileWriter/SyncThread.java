package damothread.ex16fileWriter;

public class SyncThread extends Thread {
    private Resource rs;

    public SyncThread(String name, Resource rs) {
        super(name);
        this.rs = rs;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            // место срабатывания синхронизации
            rs.writing(getName(), i);
        }
    }
}
