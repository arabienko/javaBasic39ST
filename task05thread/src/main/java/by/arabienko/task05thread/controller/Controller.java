package by.arabienko.task05thread.controller;

import by.arabienko.task05thread.bean.BeanException;
import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.service.ServiceException;

import java.util.List;

/**
 * A controller class for managing commands.
 */
public class Controller {

    private final CommandProvider commandProvider =new CommandProvider();

    private final char paramDelimiter = ' ';

    public List executeCommand(String request, List list) throws ServiceException, BeanException {
        String commandName;
        Command executionCommand;

        commandName  = request.substring(0,request.indexOf(paramDelimiter));
        executionCommand = commandProvider.getCommand(commandName);

        return executionCommand.execute(list);
    }

}
