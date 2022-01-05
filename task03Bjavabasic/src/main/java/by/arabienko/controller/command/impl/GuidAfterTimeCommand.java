package by.arabienko.controller.command.impl;

import by.arabienko.controller.ServiceFactory;
import by.arabienko.controller.command.Command;
import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.ServiceException;
import by.arabienko.service.impl.GetGuidAfterTime;
import by.arabienko.view.ViewGuid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class GuidAfterTimeCommand implements Command {
    private static final Logger LOGGER = LogManager.getLogger(GuidAfterTimeCommand.class);
    @Override
    public HashMap<String, ProgramGuide.Program> execute(List list) throws ServiceException {
        LOGGER.debug("Task received: "+ GetGuidAfterTime.class);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        return serviceFactory.getGetGuidAfterTime().
                execute((List<ProgramGuide>) list.get(0),
                        (String) list.get(1), (String) list.get(2));
    }
}
