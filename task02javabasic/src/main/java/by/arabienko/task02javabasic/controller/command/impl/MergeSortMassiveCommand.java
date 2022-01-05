package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.bean.impl.Massive;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;
import by.arabienko.task02javabasic.service.SortMassiveService;

import java.util.ArrayList;
import java.util.List;

public class MergeSortMassiveCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SortMassiveService sortMassiveService = serviceFactory.getSortMassiveMerge();
        List list1 = new ArrayList();
        list1.add(sortMassiveService.sortMassive((Massive) list.get(0)));
        return list1;
    }
}
