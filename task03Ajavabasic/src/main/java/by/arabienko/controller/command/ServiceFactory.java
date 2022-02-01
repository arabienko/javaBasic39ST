package by.arabienko.controller.command;


import by.arabienko.controller.command.impl.ParsFileCommand;
import by.arabienko.controller.command.impl.SelectOffersCommand;
import by.arabienko.controller.command.impl.SelectOptimalCommand;
import by.arabienko.controller.command.impl.WriteDateCommand;


/**
 * A factory for creating a single instance for services.
 */
public class ServiceFactory {

    private static final ServiceFactory INSTANCE =
            new ServiceFactory();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    private final Command parseFile =
            new ParsFileCommand();
    private final Command writeToFile =
            new WriteDateCommand();

    public Command getParseFile() {
        return parseFile;
    }

    public Command getWriteToFile() {
        return writeToFile;
    }

    private final Command selectOffers =
            new SelectOffersCommand();
    private final Command selectOptimal =
            new SelectOptimalCommand();

    public Command getSelectOffers() {
        return selectOffers;
    }

    public Command getSelectOptimal() {
        return selectOptimal;
    }
}
