package by.arabienko.task05thread.service.impl;

import by.arabienko.task05thread.service.FileReadService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class ReadFileImpl implements FileReadService {
    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(ReadFileImpl.class);

    @Override
    public List readFile(List listNameFile) {

        //TODO не передавать листы
        List listString = new ArrayList<>();
        String fileName = (String) listNameFile.get(0);

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        try (InputStreamReader streamReader =
                     new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine())!=null) {
                if (!line.isEmpty()) {
                    //TODO: параметризация
                    listString.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.error("Read file is error " + e);
            e.printStackTrace();
        }

        LOGGER.debug("File was read.");
        return listString;
    }
}
