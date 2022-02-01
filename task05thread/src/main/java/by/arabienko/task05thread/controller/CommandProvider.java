package by.arabienko.task05thread.controller;

import by.arabienko.task05thread.controller.command.Command;
import by.arabienko.task05thread.controller.command.CommandName;
import by.arabienko.task05thread.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * A mechanism for accessing command instances.
 */
final class CommandProvider {

    private static final Logger LOGGER = LogManager.getLogger(CommandProvider.class);

    private final Map<CommandName, Command> commandHashMap = new HashMap<>();

    CommandProvider() {
        commandHashMap.put(CommandName.READ_FILE, new FileReadCommand());
        commandHashMap.put(CommandName.SAVE_MATRIX, new SaveMatrixToFileCommand());
        commandHashMap.put(CommandName.SAVE_MASSIVE, new SaveMassiveToFileCommand());
        commandHashMap.put(CommandName.SORT_FILE, new SortFileCommand());
        commandHashMap.put(CommandName.CREATE_MASSIVE, new CreateMassiveCommand());
        commandHashMap.put(CommandName.CREATE_MATRIX, new CreateMatrixCommand());
        commandHashMap.put(CommandName.SORT_EXCHANGE, new ExchangeSortMassiveCommand());
        commandHashMap.put(CommandName.SORT_INSERT, new InsertionSortMassiveCommand());
        commandHashMap.put(CommandName.SORT_MERGE, new MergeSortMassiveCommand());
        commandHashMap.put(CommandName.SORT_SHAKER, new ShakerSortMassiveCommand());
        commandHashMap.put(CommandName.SORT_SHELL, new ShellSortMassiveCommand());
        commandHashMap.put(CommandName.SORT_SIMPLE, new SimpleSelectSortMassiveCommand());
        commandHashMap.put(CommandName.SUM_MATRIX, new MatrixSumCommand());
        commandHashMap.put(CommandName.SUBSTRACTION_MATRIX, new MatrixSubtractionCommand());
        commandHashMap.put(CommandName.MULTIPLY_MATRIX, new MatrixMultiplyCommand());
        commandHashMap.put(CommandName.WRONG_COMMAND, new WrongRequest());
    }

    Command getCommand (String name){
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commandHashMap.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e){
            LOGGER.debug("Input wrong command.");
            command = commandHashMap.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
