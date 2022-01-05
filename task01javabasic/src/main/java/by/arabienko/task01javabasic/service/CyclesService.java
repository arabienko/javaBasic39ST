package by.arabienko.task01javabasic.service;

import by.arabienko.task01javabasic.entity.Data;
import by.arabienko.task01javabasic.view.InputOutputData;
import by.arabienko.task01javabasic.view.Validation;

import java.util.List;
import java.util.Scanner;

/**
 * output numbers in reverse order.
 */
public class CyclesService {
    /**
     * @param start first parameter
     * @param end   second parameter
     */
    public void displayNumbers(final double start, final double end) {

        if (start < end) {
            for (int i = (int) end; i >= start; i--) {
                System.out.println(i);
            }
        } else {
            for (int i = (int) start; i >= end; i--) {
                System.out.println(i);
            }
        }

    }
//todo
    public double calculateResultZ() {
        List<String> list = List.of(new String[]{"+", "–", "/", "*", "0"});
        InputOutputData ioData = new InputOutputData();
        String inputStr;
        double x;
        double y;
        double result = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            inputStr = " ";
            while (!list.contains(inputStr)) {
                ioData.output("Input the sign of the operation +, –, /, *");
                inputStr = scanner.nextLine();
            }

            ioData.output("Input parameters x: ");
            x = scanner.nextDouble();
            if (inputStr.equals("/")) {
                //TODO переписать, снова к выбору операции
                do {
                    ioData.output("Division. Input parameters y: ");
                    y = scanner.nextDouble();
                } while (y == 0);
            } else {
                ioData.output("Input parameters y: ");
                y = scanner.nextDouble();
            }

            ArithmeticService arithmeticService = new ArithmeticService();

            switch (inputStr) {
                case "+": {
                    result = arithmeticService.sum(x, y);
                    ioData.output("Execution result ", result);
                    break;
                }
                case "-": {
                    result = arithmeticService.sub(x, y);
                    ioData.output("Execution result ", result);
                    break;
                }
                case "/": {
                    result = arithmeticService.divide(x, y);
                    ioData.output("Execution result ", result);
                    break;
                }
                case "*": {
                    result = arithmeticService.multiply(x, y);
                    ioData.output("Execution result ", result);
                    break;
                }
                default: {
                    ioData.output("the input sign = 0, the program is over");
                }
            }
        } while (!inputStr.equals("0"));

        return result;
    }

    public double sumFractions(final double number) throws Exception {
        Validation validation = new Validation();
        ArithmeticService arithmeticService = new ArithmeticService();
        validation.validAboveZero(number);
        double result = 0;
        for (int i = 1; i <= number; i++) {
            result = result + arithmeticService.divide(1, i);
        }
        return result;
    }

    /**
     * @param number input value.
     * @return Get all numbers not exceeding a given number N,
     * which are evenly divisible by all of their digits
     */
    public Data allNumbers(final double number){
        Data dataNumbers = new Data();
        for (int i = 1; i <= number; i++) {
            String n = Integer.toString(i);
            char[] charArray = n.toCharArray();
            int count = 0;
            for (char value : charArray) {
                int c = Character.getNumericValue(value);
                if (c != 0 && (i % c) == 0) {
                    count++;
                }
            }
            if (count == charArray.length) {
                dataNumbers.push(i);
            }
        }
        return dataNumbers;
    }

    public void tableASCII() {
        InputOutputData ioData = new InputOutputData();
        for (int i = 32; i <= 255; i++) {
            char iChar = (char) i;
            ioData.output(i, iChar);
            if (i % 9 == 0) {
                System.out.println();
            }
        }
    }
}
