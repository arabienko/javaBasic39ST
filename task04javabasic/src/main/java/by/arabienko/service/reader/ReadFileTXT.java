package by.arabienko.service.reader;

import by.arabienko.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Read TXT file to List<String>
 */
public class ReadFileTXT implements IReadFile {

    private static final Logger LOGGER =
            LogManager.getLogger(ReadFileTXT.class);

    /**
     * @param nameFile
     * @return list with strings.
     */
    @Override
    public List<String> readFile(String nameFile) {
        List<String> list = new ArrayList<>();
        InputStream is;
        try {
            is = getFileFromResourceAsStream(nameFile);
            list = printInputStream(is);
        } catch (ServiceException | IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    // get a file from the resources' folder
    // works everywhere, IDEA, unit test and JAR file.
    private static InputStream getFileFromResourceAsStream(String fileName)
            throws ServiceException, IOException {
        // The class loader that loaded the class
        ClassLoader classLoader = ReadFileJson.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        // the stream holding the file content
        if (inputStream==null) {
            LOGGER.debug("file not found! " + fileName);
            throw new ServiceException("file not found! " + fileName);
        } else {
            if (inputStream.available()==0) {
                LOGGER.debug("Read is empty " + fileName);
                throw new ServiceException("Read is empty " + fileName);
            } else {
                return inputStream;
            }
        }
    }

    // print input stream to list
    private static List<String> printInputStream(InputStream is)
            throws ServiceException {
        List<String> lines = new ArrayList<>();
        try (InputStreamReader streamReader =
                     new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine())!=null) {
                lines.add(line);
            }
        } catch (IOException e) {
            LOGGER.debug("Read error " + e);
            throw new ServiceException("Read error ", e);
        }
        return lines;
    }
}
