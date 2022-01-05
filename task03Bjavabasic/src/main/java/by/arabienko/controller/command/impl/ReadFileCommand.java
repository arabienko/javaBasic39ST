package by.arabienko.controller.command.impl;

import by.arabienko.controller.ServiceFactory;
import by.arabienko.controller.command.Command;
import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.ServiceException;
import by.arabienko.service.impl.ReadFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ReadFileCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(ReadFileCommand.class);
    @Override
    public HashMap<String, ProgramGuide.Program> execute(List list)
            throws ServiceException, IOException {
        LOGGER.debug("Task received: "+ ReadFile.class);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        return serviceFactory.getFileInterface().
                read((String) list.get(0));
    }
}
