package by.arabienko.controller.command;


import by.arabienko.service.ServiceException;

import java.io.IOException;
import java.util.List;

/**
 * Interface command
 */
public interface Command {

    List execute( List list) throws ServiceException, IOException;
}
