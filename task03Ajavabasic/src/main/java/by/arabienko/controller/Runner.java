package by.arabienko.controller;

import by.arabienko.service.ServiceException;
import by.arabienko.view.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Runner {

    /**
     * Logging events.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(Runner.class);

    public static void main(String[] args)
            throws IOException, ServiceException {

        LOGGER.info("Start of selection of loan offers.");
        Client.client();
        LOGGER.info("End of choice.");
    }
}
