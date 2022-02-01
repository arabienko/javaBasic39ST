package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.service.ServiceException;
import by.arabienko.service.IWorkWithFileJson;
import by.arabienko.service.impl.ParseDateFromFileJson;

import java.io.IOException;
import java.util.List;


/**
 * Parse (read) from file command
 */
public class ParsFileCommand implements Command {

    @Override
    public List execute(List list)
            throws ServiceException, IOException {

        IWorkWithFileJson workWithFileJson =
                new ParseDateFromFileJson();

       return workWithFileJson.
               workWithFile(list);
    }
}
