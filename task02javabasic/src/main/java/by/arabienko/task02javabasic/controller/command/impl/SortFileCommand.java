package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;
import by.arabienko.task02javabasic.service.SortDateFileService;

import java.util.List;

public class SortFileCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {
        ServiceFactory serviceFactory =ServiceFactory.getInstance();
        SortDateFileService sortDateFileService = serviceFactory.getSortDateService();
        return sortDateFileService.sortDate(list);
    }
}
