package by.arabienko.task02javabasic.controller;

import by.arabienko.task02javabasic.view.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    /**
     * Define a static logger variable.
     */
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    /**
     * Run program.
     *
     * @param args start
     */
    public static void main(final String[] args) {

        LOGGER.info("Start application.");
        Client.selectTask();
        LOGGER.info("Ending application.");

    }
}




