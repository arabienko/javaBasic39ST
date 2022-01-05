package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.CreateArrayService;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;

import java.util.List;

public class CreateMatrixCommand implements Command {
    @Override
    public List execute(List list) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CreateArrayService createArrayService = serviceFactory.getMatrixService();
        return createArrayService.createArray(list);
    }
}
