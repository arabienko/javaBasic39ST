package by.arabienko.task02javabasic.controller.command.impl;

import by.arabienko.task02javabasic.bean.BeanException;
import by.arabienko.task02javabasic.controller.command.Command;
import by.arabienko.task02javabasic.service.MatrixOperationService;
import by.arabienko.task02javabasic.service.ServiceException;
import by.arabienko.task02javabasic.controller.command.ServiceFactory;

import java.util.List;

public class MatrixSubtractionCommand implements Command {
    @Override
    public List execute(List list) throws ServiceException, BeanException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        MatrixOperationService matrixOperationService = serviceFactory.getMatrixSubtraction();
        return matrixOperationService.matrixOperation(list);
    }
}
