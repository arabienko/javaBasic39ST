package by.arabienko.service.impl;

import by.arabienko.service.ExceptionService;
import by.arabienko.service.IReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class ReaderFromFile implements IReader {
    private static final Logger LOGGER =
            LogManager.getLogger(WriterToFile.class);
    @Override
    public String readFromFile(String path) {
        String text = "";
        try {
            if (path.length() == 0){
                LOGGER.debug("File not found. " + path);
                throw new ExceptionService("File not found. " + path);
            }
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream stream =
                    classLoader.getResourceAsStream(path);
            byte[] str = new byte[stream.available()];
            stream.read(str);
            text = new String(str);
            stream.close();
            LOGGER.debug("The text is read into a line. "+path);
        } catch (IOException | ExceptionService e) {
            LOGGER.debug("Error reading file... "+path);
            e.printStackTrace();
        }
        return text;
    }
}
