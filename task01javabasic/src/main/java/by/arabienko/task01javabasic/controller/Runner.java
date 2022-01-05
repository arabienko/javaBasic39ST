package by.arabienko.task01javabasic.controller;

import by.arabienko.task01javabasic.view.SelectTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    /**
     * Define a static logger variable.
     */
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    /**
     * Run program.
     * @param args start
     */
    public static void main(final String[] args) {
        LOGGER.info("Start application.");
        SelectTask selectTask = new SelectTask();
        selectTask.selectNumberTask();
        LOGGER.info("Ending application.");
    }
}




