package by.arabienko.task05thread.service;

import by.arabienko.task05thread.bean.BeanException;

import java.util.List;

/**
 *
 */
public interface MatrixOperationService {

    List matrixOperation(List list) throws ServiceException, BeanException;
}
