package by.arabienko.task05thread.controller.command.impl;

import by.arabienko.task05thread.bean.BeanException;
import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.service.MatrixOperationService;
import by.arabienko.task05thread.service.ServiceException;
import by.arabienko.task05thread.controller.command.ServiceFactory;

import java.util.List;

public class MatrixSubtractionCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException, BeanException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperationService matrixOperationService = serviceFactory.getMatrixSubtraction();
        return matrixOperationService.matrixOperation(list);
    }
}
