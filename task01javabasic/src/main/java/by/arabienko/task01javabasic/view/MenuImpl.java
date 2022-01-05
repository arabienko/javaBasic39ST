package by.arabienko.task01javabasic.view;

import by.arabienko.task01javabasic.controller.Command;
import by.arabienko.task01javabasic.controller.impl.*;
import by.arabienko.task01javabasic.entity.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * class Menu.
 * user interaction
 */
public class MenuImpl {

    /**
     * Logging events.
     */
    private static final Logger LOGGER = LogManager.getLogger(MenuImpl.class);

    /**
     * Method for selecting an expression and outputting the result.
     */
    public void displayMenuFirst() {
        InputOutputData iodata = new InputOutputData();
        Validation validation = new Validation();
        iodata.output("Select the expression number to calculate:" +
                " \n1. X+3;" +
                " \n2. Converting radians to degrees\n" +
                "3. Circumference and Area of a circle \n" +
                "4. Area of triangle(on both sides and corner)\n" +
                "5. Expression like a*X^3 + b*X^2 + c*X + d. :");

        try (Scanner scanner = new Scanner(System.in)) {

            int select = scanner.nextInt();
            Command command;
            Data result;
            Data data;

            switch (select) {
                case 1:
                    data = new Data();
                    command = new Sum();
                    LOGGER.debug("Task (X+3) was selected "
                            + command.getClass());
                    iodata.output("Input X:");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.input(data, 3);
                    result = command.exec(data);
                    iodata.output(result);
                    LOGGER.debug("Task completed successful" +
                            " (X+3)");
                    break;

                case 2:
                    data = new Data();
                    command = new Transformation();
                    LOGGER.debug("Task (Converting radians to degrees)" +
                            " was selected " + command.getClass());
                    iodata.output("Input radians");
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Return result in Deg - Min - Sec:", result);
                    LOGGER.debug("Task completed successful" +
                            " (Converting radians to degrees)");
                    break;

                case 3:
                    data = new Data();
                    command = new Circle();
                    LOGGER.debug("Task (Circumference and Area of a circle)" +
                            " was selected " + command.getClass());
                    iodata.output("Input circle radius");
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    validation.validNoZero(select);
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Circumference: ", result);
                    command = new AreaOfCircle();
                    result = command.exec(data);
                    iodata.output("Area of a circle: ", result);
                    LOGGER.debug("Task completed successful" +
                            " (Circumference and Area of a circle)");
                    break;

                case 4:
                    data = new Data();
                    command = new TriangleArea();
                    LOGGER.debug("Task (Area of triangle" +
                            " (on both sides and corner)) " +
                            "was selected " + command.getClass());
                    iodata.output("For counting area of triangle," +
                            " input X (press Enter), Y (press Enter) " +
                            "and a (in degrees)(press Enter) ");
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Area of triangle= ", result);
                    LOGGER.debug("Task completed successful" +
                            " (Area of triangle(on both sides and corner))");
                    break;

                case 5:
                    data = new Data();
                    command = new Expression();
                    LOGGER.debug("Task (Expression like " +
                            "a*X^3 + b*X^2 + c*X + d " +
                            "was selected " + command.getClass());
                    iodata.output("Input X");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input a");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input b");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input c");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input d");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Result expressions: ", result);
                    LOGGER.debug("Task completed successful" +
                            " (Expression like a*X^3 + b*X^2 + c*X + d. )");
                    break;

                default:
                    iodata.output("Incorrect input.");
                    LOGGER.debug("Invalid value entered (not 1,2,3,4,5)");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Incorrect input. Try another time" + e);
            LOGGER.error("Incorrect input. Try another time" + e);
        } finally {
            iodata.output("You can start program again ");
        }
    }

    public void displayMenuSecond() {
        InputOutputData iodata = new InputOutputData();
        Validation validation = new Validation();
        iodata.output("Select the expression number to calculate: \n" +
                "1. Compare two numbers\n" +
                "2. Determine which of the three numbers is d." +
                " If none is equal to d, then find max\n" +
                "3. Determine if a triangle exists \n" +
                "4. Calculate the value of a function\n" +
                "5. Finding the sum of the larger and" +
                " smaller of three numbers :");
        try (Scanner scanner = new Scanner(System.in)) {

            int select = scanner.nextInt();
            Command command;
            Data result;
            Data data;

            switch (select) {
                case 1:
                    data = new Data();
                    command = new CompareTwoNumbers();
                    LOGGER.debug("Task (Compare two numbers)" +
                            " was selected " + command.getClass());
                    iodata.output("Input number one:");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input number two:");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output(result);
                    LOGGER.debug("Task completed successful" +
                            " (Compare two numbers)");
                    break;

                case 2:
                    data = new Data();
                    command = new EqualNumberD();
                    LOGGER.debug("Task (What number equals to the number)" +
                            " was selected " + command.getClass());
                    iodata.output("Input number A: ");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input number B: ");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input number C: ");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input number D: ");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Mux sub: ", result);
                    LOGGER.debug("Task completed successful" +
                            " (What number equals to the number)");
                    break;

                case 3:
                    data = new Data();
                    command = new CornersTriangle();
                    LOGGER.debug("Task (Determine if a triangle exists)" +
                            " was selected " + command.getClass());
                    iodata.output("Input the first corner");
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    iodata.output("Input the second corner");
                    select = scanner.nextInt();
                    validation.validAboveZero(select);
                    iodata.input(data, select);
                    command.exec(data);
                    LOGGER.debug("Task completed successful" +
                            " (Determine if a triangle exists)");
                    break;

                case 4:
                    data = new Data();
                    command = new FunctionExecute();
                    LOGGER.debug("Task (Calculate the value of a function)" +
                            " was selected " + command.getClass());
                    iodata.output("Input argument X");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Result function ", result);
                    LOGGER.debug("Task completed successful" +
                            " (Calculate the value of a function)");
                    break;

                case 5:
                    data = new Data();
                    command = new MaxMinCompareNumber();
                    LOGGER.debug("Task " +
                            "(Finding the sum of the larger and" +
                            " smaller of three numbers) " +
                            "was selected " + command.getClass());
                    iodata.output("Input three difference numbers");
                    iodata.output("Input A");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input B");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    iodata.output("Input C");
                    select = scanner.nextInt();
                    iodata.input(data, select);
                    result = command.exec(data);
                    iodata.output("Sum Max and Min numbers: ", result);
                    LOGGER.debug("Task completed successful" +
                            " (Finding the sum of the larger " +
                            "and smaller of three numbers)");
                    break;

                default:
                    iodata.output("Incorrect input.");
                    LOGGER.debug("Invalid value entered (not 1,2,3,4,5)");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Incorrect input. Try another time: " + e);
            LOGGER.error("Incorrect input. Try another time" + e);
        } finally {
            iodata.output("You can start program again ");
        }
    }

    public void displayMenuThird() {
        InputOutputData iodata = new InputOutputData();
        Validation validation = new Validation();
        iodata.output("Select the expression number to calculate: \n" +
                "1. Display numbers from X to Y in reverse order\n" +
                "2. Write a simple arithmetic expression\n" +
                "3. Calculate the amount 1/1+1/2...1/n \n" +
                "4. Get all numbers not exceeding a given number N," +
                " which are evenly divisible by all of their digits\n" +
                "5. ASCII table :");

        try (Scanner scanner = new Scanner(System.in)) {
            Command command;
            Data result;
            Data data;
            double choice;
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    data = new Data();
                    command = new DisplayNumbers();
                    LOGGER.debug("Task (Display numbers from X " +
                            "to Y in reverse order)" +
                            " was selected " + command.getClass());
                    iodata.output("Input number one:");
                    choice = scanner.nextDouble();
                    iodata.input(data, choice);
                    iodata.output("Input number two:");
                    choice = scanner.nextDouble();
                    iodata.input(data, choice);
                    command.exec(data);
                    LOGGER.debug("Task complete successful" +
                            " (Display numbers from X " +
                            "to Y in reverse order)");
                    break;

                case 2:
                    data = new Data();
                    command = new CalculateResultZ();
                    LOGGER.debug("Task (Write a simple " +
                            "arithmetic expression)" +
                            " was selected " + command.getClass());
                    result = command.exec(data);
                    iodata.output("Result: ", result);
                    LOGGER.debug("Task complete successful" +
                            " (Write a simple arithmetic expression)");
                    break;

                case 3:
                    data = new Data();
                    command = new SumFractions();
                    LOGGER.debug("Task (Calculate the amount 1/1+1/2...1/n)" +
                            " was selected " + command.getClass());
                    iodata.output("Input number");
                    choice = scanner.nextDouble();
                    iodata.input(data, choice);
                    result = command.exec(data);
                    iodata.output("Result: ", result);
                    LOGGER.debug("Task complete successful" +
                            " (Calculate the amount 1/1+1/2...1/n)");
                    break;

                case 4:
                    data = new Data();
                    command = new AllNumbers();
                    LOGGER.debug("Task" +
                            " (Get all numbers not exceeding " +
                            "a given number N) was selected "
                            + command.getClass());
                    iodata.output("Input number N");
                    choice = scanner.nextDouble();
                    validation.validAboveZero(choice);
                    iodata.input(data, choice);
                    result = command.exec(data);
                    iodata.output("Result: ", result);
                    LOGGER.debug("Task complete successful" +
                            " (Get all numbers not exceeding " +
                            "a given number N)");
                    break;

                case 5:
                    data = new Data();
                    command = new TableASCII();
                    LOGGER.debug("Task (ASCII table)" +
                            " was selected " + command.getClass());
                    command.exec(data);
                    LOGGER.debug("Task complete successful" +
                            " (ASCII table)");
                    break;

                default:
                    iodata.output("Incorrect input.");
                    LOGGER.debug("Invalid value entered (not 1,2,3,4,5)");
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Incorrect input. " +
                    "Try launch program again: " + e);
            LOGGER.error("Incorrect input: " + e);
        } finally {
            iodata.output("You can start program again ");
        }
    }
}
