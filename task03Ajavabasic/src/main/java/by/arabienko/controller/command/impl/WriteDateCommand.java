package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.service.ServiceException;
import by.arabienko.service.IWorkWithFileJson;
import by.arabienko.service.impl.WriteDateToFileJson;

import java.io.IOException;
import java.util.List;

/**
 * Write to file command
 */
public class WriteDateCommand implements Command {

    @Override
    public List execute(List list)
            throws ServiceException, IOException {
        IWorkWithFileJson workWithFileJson =
                new WriteDateToFileJson();
        return workWithFileJson.workWithFile(list);

    }
}
