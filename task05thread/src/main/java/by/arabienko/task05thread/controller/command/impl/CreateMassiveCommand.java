package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.service.CreateArrayService;
import by.arabienko.task05thread.controller.command.ServiceFactory;

import java.util.List;

public class CreateMassiveCommand implements Command {

    @Override
    public List execute(List list) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CreateArrayService createArrayService = serviceFactory.getMassiveService();
        return createArrayService.createArray(list);
    }
}
