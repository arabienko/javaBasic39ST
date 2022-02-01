package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.service.SaveToFileService;
import by.arabienko.task05thread.controller.command.ServiceFactory;

import java.util.List;

public class SaveMatrixToFileCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SaveToFileService saveToFileService = serviceFactory.getSaveMatrixToFile();
        return saveToFileService.saveToFile(list);
    }
}
