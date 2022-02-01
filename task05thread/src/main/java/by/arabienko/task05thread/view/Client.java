package by.arabienko.task05thread.view;

import by.arabienko.task05thread.controller.Controller;
import by.arabienko.task05thread.controller.command.FactoryCreatorArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    /**
     * Method for selecting an expression and outputting the result.
     */
    public static void selectTask() {

        List list = new ArrayList();
        List list2 = new ArrayList();
        List list3 = new ArrayList();

        FactoryCreatorArray factoryCreatorArray = FactoryCreatorArray.getInstance();
        Controller controller = new Controller();

        InputOutputData dateIO = new InputOutputData();
        String selectClient;
        String selectClientTwo;
        String selectClientOperation;

        dateIO.output("Select number : \n" +
                "1. Sort massive\n" +
                "2. Operations on matrices .\n" +
                "3. Sort File ");
        try (Scanner scanner = new Scanner(System.in)) {
            selectClient = scanner.next();
            switch (selectClient) {
                case "1":
                    dateIO.output("Sort massive, name file : ");
                    selectClient = scanner.next();
                    dateIO.output("Sort massive,method sorting \n " +
                            "(SORT_EXCHANGE,SORT_INSERT, SORT_MERGE, SORT_SHAKER, SORT_SHELL,SORT_SIMPLE): ");
                    selectClientOperation = scanner.next();
                    selectClientOperation = selectClientOperation + " ";
                    list.add(selectClient);

                    list3.add(factoryCreatorArray.getMassiveService().
                            factoryMethod(controller.executeCommand("CREATE_MASSIVE ",
                                    controller.executeCommand("READ_FILE ", list))));


                    dateIO.output("The name of the file with the saved result " +
                            controller.executeCommand("SAVE_MASSIVE ", controller.
                                    executeCommand(selectClientOperation, list3)).get(0).toString());
                    LOGGER.debug("Sort massive completed successful");
                    break;

                case "2":
                    dateIO.output("Operations on matrices, enter the names of the data files: ");
                    selectClient = scanner.next();
                    selectClientTwo = scanner.next();
                    dateIO.output("select operation (SUM_MATRIX, SUBSTRACTION_MATRIX, MULTIPLY_MATRIX): ");
                    selectClientOperation = scanner.next();
                    selectClientOperation = selectClientOperation + " ";
                    list.add(selectClient);
                    list2.add(selectClientTwo);


                    list3.add(factoryCreatorArray.getMatrixService().
                            factoryMethod(controller.executeCommand("CREATE_MATRIX ",
                                    controller.executeCommand("READ_FILE ", list))));

                    list3.add(factoryCreatorArray.getMatrixService().
                            factoryMethod(controller.executeCommand("CREATE_MATRIX ",
                                    controller.executeCommand("READ_FILE ", list2))));

                    dateIO.output("The name of the file with the saved result " +
                            controller.executeCommand("SAVE_MATRIX ", controller.
                                    executeCommand(selectClientOperation, list3)).get(0).toString()
                    );

                    LOGGER.debug("Operations on matrices completed successful");
                    break;

                case "3":

                    dateIO.output("Sort big file, input nameFile: ");
                    selectClient = scanner.next();
                    list.add(selectClient);
                    dateIO.output("Sorting result in file " +
                            controller.executeCommand("SORT_FILE ", list));
                    break;

                default:

                    LOGGER.debug("Invalid value entered (WRONG_COMMAND)");
                    dateIO.output(
                            (String) controller.executeCommand("WRONG_COMMAND ", list).get(0));

            }
            scanner.close();
        } catch (Exception e) {
            LOGGER.error("Incorrect input.  " + e);
            System.out.println("Incorrect input. Try another time: " + e);
        }
    }
}

