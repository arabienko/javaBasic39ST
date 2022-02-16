package by.arabienko.controller;

import java.util.List;

/**
 * A command for sorting text
 * from a file according
 * to the specified parameters.
 */
public interface Command {

    void execute(List list);
}
