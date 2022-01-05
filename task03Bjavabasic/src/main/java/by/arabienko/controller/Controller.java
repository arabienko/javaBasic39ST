package by.arabienko.controller;

import by.arabienko.controller.command.Command;
import by.arabienko.controller.command.impl.GuidAfterTimeCommand;
import by.arabienko.controller.command.impl.GuidChannelCommand;
import by.arabienko.controller.command.impl.ReadFileCommand;
import by.arabienko.service.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Controller {
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);
    public HashMap executeTask (int select, List list) throws ServiceException, IOException {
        HashMap hashMapGuid;
        HashMap hashMapRead;
        Command command;
        switch (select){
            case 1:
                command = new ReadFileCommand();
                hashMapRead = command.execute(list);
                command = new GuidAfterTimeCommand();
                list.set(0, hashMapRead.get(0));
                hashMapGuid = command.execute(list);
                break;
            case 2:
                command = new ReadFileCommand();
                hashMapRead = command.execute(list);
                command = new GuidChannelCommand();
                list.set(0, hashMapRead.get(0));
                hashMapGuid = command.execute(list);
                break;
            default:
                LOGGER.error("Unexpected value: " + select);
                throw new IllegalStateException("Unexpected value: " + select);
        }
        return hashMapGuid;
    }
}
