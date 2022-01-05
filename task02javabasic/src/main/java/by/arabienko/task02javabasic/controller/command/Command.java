package by.arabienko.task02javabasic.controller.command;

import by.arabienko.task02javabasic.bean.BeanException;
import by.arabienko.task02javabasic.service.ServiceException;

import java.util.List;

/**
 * Interface command
 */
public interface Command {

    List execute( List list) throws ServiceException, BeanException;
}
