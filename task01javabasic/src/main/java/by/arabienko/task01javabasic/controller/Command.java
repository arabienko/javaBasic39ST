package by.arabienko.task01javabasic.controller;

import by.arabienko.task01javabasic.entity.Data;

/**
 *General interface for getting the result of an expression.
 */
public interface Command {

        /**
         * @param newData - list date for execute
         * @return - list date
         * @throws Exception
         */
        Data exec(Data newData) throws Exception;

}
