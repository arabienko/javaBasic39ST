package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.service.SaveToFileService;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;

import java.util.List;

public class SaveMatrixToFileCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        SaveToFileService saveToFileService = serviceFactory.getSaveMatrixToFile();
        return saveToFileService.saveToFile(list);
    }
}
