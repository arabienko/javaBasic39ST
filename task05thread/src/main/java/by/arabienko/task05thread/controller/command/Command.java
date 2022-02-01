package by.arabienko.task05thread.controller.command;

import by.arabienko.task05thread.bean.BeanException;
import by.arabienko.task05thread.service.ServiceException;

import java.util.List;

/**
 * Interface command
 */
public interface Command {

    List execute( List list) throws ServiceException, BeanException;
}
