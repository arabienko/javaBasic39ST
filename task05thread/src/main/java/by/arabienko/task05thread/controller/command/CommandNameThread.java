package by.arabienko.task05thread.controller.command;

import java.util.List;
import java.util.Random;

/**
 * The Enum class listing
 * the names of commands
 * on matrices and arrays.
 * A method has been implemented
 * that randomly returns
 * the names of commands
 * from enumerations.
 */
public enum CommandNameThread {
    SUM_MATRIX, SUBSTRACTION_MATRIX, MULTIPLY_MATRIX,
    SORT_EXCHANGE,SORT_INSERT, SORT_MERGE,
    SORT_SHAKER, SORT_SHELL,SORT_SIMPLE;

    private static final List<CommandNameThread> VALUES =
            List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static CommandNameThread randomCommandThread()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
