package by.arabienko.task02javabasic.service;

import by.arabienko.task02javabasic.bean.BeanException;

import java.util.List;

/**
 *
 */
public interface MatrixOperationService {

    List matrixOperation(List list) throws ServiceException, BeanException;
}
