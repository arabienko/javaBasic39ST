package by.arabienko.service.reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import by.arabienko.service.exception.ServiceException;
import by.arabienko.service.validation.Validation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Read Json file to List<String>
 */
public class ReadFileJson implements IReadFile {

    private static final Logger LOGGER = LogManager.getLogger(ReadFileJson.class);

    /**
     * @param nameFile
     * @return list with strings.
     */
    @Override
    public List<String> readFile(String nameFile){
        ObjectMapper mapper = new ObjectMapper();
        List<String> list = new ArrayList<>();
        InputStream is;
        try {
            is = getFileFromResourceAsStream(nameFile);
            list = mapper.readValue(is, List.class);
        } catch (ServiceException | IOException e) {
            LOGGER.debug("File read error. "+ e);
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param fileName
     * @return stream
     * @throws ServiceException
     * @throws IOException
     */
    private static InputStream getFileFromResourceAsStream(String fileName)
            throws ServiceException, IOException {
        // The class loader that loaded the class
        ClassLoader classLoader = ReadFileJson.
                class.getClassLoader();
        InputStream inputStream = classLoader.
                getResourceAsStream(fileName);
        // the stream holding the file content
        if (inputStream == null ) {
            LOGGER.debug("file not found! "
                    + fileName);
            throw new ServiceException("file not found! "
                    + fileName);
        } else {
            if (inputStream.available() == 0) {
                LOGGER.debug("Read is empty "
                        + fileName);
                throw new ServiceException("Read is empty "
                        + fileName);
            } else {
                return inputStream;
            }
        }
    }
}
