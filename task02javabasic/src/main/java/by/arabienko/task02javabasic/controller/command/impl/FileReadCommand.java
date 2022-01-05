package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.FileReadService;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;

import java.util.List;

public class FileReadCommand implements Command {
    @Override
    public List execute(List list) {

        String str = (String) list.get(0);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        FileReadService createArrayService = serviceFactory.getFileReadService();
        return createArrayService.readFile(list);
    }
}
