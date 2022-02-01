package by.arabienko.controller.command.impl;

import by.arabienko.controller.command.Command;
import by.arabienko.service.ServiceException;
import by.arabienko.service.ISelectCredit;
import by.arabienko.service.impl.SelectCreditsForOffer;

import java.util.List;

/**
 * Command Selection of banking offer
 */
public class SelectOffersCommand implements Command {

    @Override
    public List execute(List list)
            throws ServiceException {
         ISelectCredit selectCreditInterface =
                 new SelectCreditsForOffer();
        return selectCreditInterface.selectCredit(
                (List) list.get(0),
                (String) list.get(1),
                (int)list.get(2),
                (Integer) list.get(3));
    }
}
