package by.arabienko.service;

import java.io.IOException;
import java.util.List;

/**
 * Interface for work with file (read, write).
 */
public interface IWorkWithFileJson {

    List workWithFile(List list) throws IOException, ServiceException;
}
