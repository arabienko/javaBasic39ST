package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.CreateArrayService;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;

import java.util.List;

public class CreateMassiveCommand implements Command {

    @Override
    public List execute(List list) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CreateArrayService createArrayService = serviceFactory.getMassiveService();
        return createArrayService.createArray(list);
    }
}
