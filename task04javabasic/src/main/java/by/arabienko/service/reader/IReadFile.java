package by.arabienko.service.reader;

import by.arabienko.service.exception.ServiceException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Read file.
 */
public interface IReadFile {
    /**
     * @param nameFile
     * @return list with strings.
     * @throws URISyntaxException
     * @throws IOException
     * @throws ServiceException
     */
    List <String> readFile(String nameFile)
            throws URISyntaxException, IOException, ServiceException;
}
