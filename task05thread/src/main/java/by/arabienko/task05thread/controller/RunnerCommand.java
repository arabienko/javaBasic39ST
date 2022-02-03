package by.arabienko.task05thread.controller;

import by.arabienko.task05thread.controller.command.CommandNameThread;
import by.arabienko.task05thread.controller.command.CommandThread;
import by.arabienko.task05thread.controller.command.commandThread.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;

/**
 * Implementation of
 * imitation of custom
 * calls to commands
 * that perform operations
 * on matrices and arrays.
 */
public class RunnerCommand {
    private static final Logger LOGGER
            = LogManager.getLogger(RunnerCommand.class);
    public static void main(String[] args) {
        SimpleDateFormat sdf =
                new SimpleDateFormat("MMM dd,yyyy HH:mm:ss:FFF");

        long startTime = System.currentTimeMillis();
        LOGGER.debug("Starting to simulate " +
                "the work of the client side... Start time: " + sdf.format(startTime));
        System.out.println("Start time: " + sdf.format(startTime));
        CommandThread command;
        for (int i = 0; i < 10; i++) {
            CommandNameThread str =
                    CommandNameThread.randomCommandThread();
            switch (str) {
                case SORT_MERGE:
                    command = new CommandMergeArray();
                    command.execute();
                    break;
                case SORT_SHELL:
                    command = new CommandShellArray();
                    command.execute();
                    break;
                case SORT_INSERT:
                    command = new CommandInsertionArray();
                    command.execute();
                    break;
                case SORT_SHAKER:
                    command = new CommandShakerArray();
                    command.execute();
                    break;
                case SORT_SIMPLE:
                    command = new CommandSimpleArray();
                    command.execute();
                    break;
                case SORT_EXCHANGE:
                    command = new CommandExchangeArray();
                    command.execute();
                    break;
                case SUM_MATRIX:
                    command = new CommandMatricesSum();
                    command.execute();
                    break;
                case MULTIPLY_MATRIX:
                    command = new CommandMatricesMultiply();
                    command.execute();
                    break;
                case SUBSTRACTION_MATRIX:
                    command = new CommandMatricesSubstraction();
                    command.execute();
                    break;
                default:
                    LOGGER.error("Something went wrong...");
            }
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total execution time: " + totalTime + " ms");
        LOGGER.debug("Finish to simulate " +
                "the work of the client side... " +
                "Total execution: ms " + totalTime);
    }
}
