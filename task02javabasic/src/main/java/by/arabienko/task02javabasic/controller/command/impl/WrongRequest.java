package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class WrongRequest implements Command {

    @Override
    public List execute(List list) throws ServiceException {
        List <String>newList = new ArrayList();
        String str = "Wrong command";
        newList.add(str);
        return newList;
    }
}
