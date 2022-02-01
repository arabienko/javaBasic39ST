package by.arabienko.task05thread.service.threadImpl;

import by.arabienko.task05thread.service.IThread;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class CommonResourceReadFromFile implements Callable<List>, IThread {
    private InputStream inputStream;
    private ReentrantLock locker;
    private String nameThread;

    public CommonResourceReadFromFile(ReentrantLock locker, String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        this.inputStream = classLoader.getResourceAsStream(name);
        this.locker = locker;
        this.nameThread = name;
    }

    @Override
    public String getNameThread() {
        return nameThread;
    }

    @Override
    public List call() throws Exception {
        locker.lock();
        List listString = new ArrayList<>();
        try {
            InputStreamReader streamReader =
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            TimeUnit.MILLISECONDS.sleep(100);

            String line;
            while ((line = reader.readLine())!=null) {
                if (!line.isEmpty()) {
                    listString.add(line);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.err.print(e);
        } finally {
            locker.unlock();
        }
        return listString;
    }

}
