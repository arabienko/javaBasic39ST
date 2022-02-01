package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.controller.command.ServiceFactory;
import by.arabienko.task05thread.service.SortDateFileService;

import java.util.List;

public class SortFileCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {
        ServiceFactory serviceFactory =ServiceFactory.getInstance();
        SortDateFileService sortDateFileService = serviceFactory.getSortDateService();
        return sortDateFileService.sortDate(list);
    }
}
