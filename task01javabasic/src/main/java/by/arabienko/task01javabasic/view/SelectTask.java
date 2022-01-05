package by.arabienko.task01javabasic.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * Select task for execute.
 */
public class SelectTask {

    private static final Logger LOGGER = LogManager.getLogger(SelectTask.class);

    /**
     * Menu for selecting a task.
     */
    public void selectNumberTask() {
        InputOutputData ioData = new InputOutputData();
        MenuImpl menu = new MenuImpl();
        ioData.output("Select task:" +
                " \nLinear - 1; \nBranching - 2;" +
                " \nLoops - 3: ");
        try (Scanner scanner = new Scanner(System.in)) {
            int select = scanner.nextInt();
            switch (select) {
                case 1: {
                    LOGGER.debug("Task one was selected");
                    menu.displayMenuFirst();
                    break;
                }
                case 2: {
                    LOGGER.debug("Task two was selected");
                    menu.displayMenuSecond();
                    break;
                }
                case 3: {
                    LOGGER.debug("Task three was selected");
                    menu.displayMenuThird();
                    break;
                }
                default:
                    ioData.output("Incorrect input.");
                    LOGGER.error("Incorrect input (TaskSelect) (not 1, 2, 3)");
            }
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Incorrect input.");
            LOGGER.error("Incorrect input. Try another time" + ex);
        }
    }
}
