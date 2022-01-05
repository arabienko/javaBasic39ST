package by.arabienko.controller.command;

import by.arabienko.entity.ProgramGuide;
import by.arabienko.service.ServiceException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Command {

    HashMap<String, ProgramGuide.Program> execute (List list)
            throws ServiceException, IOException;
}
