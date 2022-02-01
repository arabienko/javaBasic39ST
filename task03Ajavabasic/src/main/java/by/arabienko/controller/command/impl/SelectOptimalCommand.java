package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.service.ServiceException;
import by.arabienko.service.ISelectCredit;
import by.arabienko.service.impl.SelectCreditOptimal;

import java.util.List;

/**
 * Command Selection of banking optimal offer
 */
public class SelectOptimalCommand implements Command {
    @Override
    public List execute(List list)
            throws ServiceException {
        ISelectCredit selectCreditInterface =
                new SelectCreditOptimal();
        return selectCreditInterface.selectCredit(
                (List) list.get(0),
                (String) list.get(1),
                (Integer) list.get(2),
                (int) list.get(3));
    }
}
