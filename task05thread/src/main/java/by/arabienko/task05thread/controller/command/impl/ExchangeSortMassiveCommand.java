package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.bean.impl.Massive;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.controller.command.ServiceFactory;
import by.arabienko.task05thread.service.SortMassiveService;

import java.util.ArrayList;
import java.util.List;

public class ExchangeSortMassiveCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {
        ServiceFactory serviceFactory =ServiceFactory.getInstance();
        SortMassiveService sortMassiveService = serviceFactory.getSortMassiveExchange();
        List list1 = new ArrayList();
        list1.add(sortMassiveService.sortMassive((Massive) list.get(0)));
        return list1;
    }
}
