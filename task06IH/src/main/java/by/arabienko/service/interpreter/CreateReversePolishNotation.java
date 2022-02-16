package by.arabienko.service.interpreter;

import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Converts a binary expression
 * to reverse Polish notation.
 * The following operations are
 * implemented for expressions:
 * <<, >>, >>>, ~, ^, |, &.
 */
public class CreateReversePolishNotation {

    public ArrayDeque<String> creationReverse(String str) {
        final String leftBracket = "(";
        final String rightBracket = ")";
        ArrayDeque<String> reverseNotation =
                new ArrayDeque<>();
        ArrayDeque<String> operators =
                new ArrayDeque<>();
        Pattern numbersAndOperations = Pattern.compile(
                "[\\p{Digit}]+|[>]+|[<]+|[(]|[~]|[)]|[&]|[|]|[\\^]");
        Matcher matcher =
                numbersAndOperations.matcher(str);
        while (matcher.find()) {
            if (!isOperator(matcher.group())) {
                reverseNotation.add(matcher.group());
            }
            if (isOperator(matcher.group())) {
                String operator = matcher.group();
                if (operators.isEmpty()) {
                    operators.add(operator);
                    continue;
                }
                if (operator.equals(leftBracket)) {
                    operators.add(operator);
                    continue;
                }
                if (operator.equals(rightBracket)) {
                    while (!operators.isEmpty()
                            && !operators.getLast().
                            equals(leftBracket)) {
                        String opr = operators.getLast();
                        reverseNotation.add(opr);
                        operators.removeLast();
                    }
                    operators.removeLast();
                    continue;
                }
                while (!operators.isEmpty()
                            && (priority(operator) < priority(operators.getLast()))
                            && !operators.getLast().equals(leftBracket)) {
                        reverseNotation.add(operators.getLast());
                        operators.removeLast();
                    }
                    operators.add(operator);
            }
        }
        if (!operators.isEmpty()) {
            while (!operators.isEmpty()) {
                if (!operators.getLast().equals(leftBracket)) {
                    reverseNotation.add(operators.removeLast());
                } else {
                    operators.removeLast();
                }
            }
        }
        return reverseNotation;
    }

    /**
     * @param operator
     * @return true if one of
     * the characters below:
     * <<, >>, >>>, ~, ^, |, &.
     */
    private static boolean isOperator(String operator) {
        return operator.equals("|") || operator.equals("&")
                || operator.equals("^") || operator.equals("~")
                || operator.equals("<<") || operator.equals(">>")
                || operator.equals(">>>") || operator.equals(")")
                || operator.equals("(");
    }

    /**
     * @param operatorPriority
     * @return the method returns the priority
     * of the operation: the higher the priority,
     * the smaller the number returned.
     */
    private static int priority(String operatorPriority) {
        switch (operatorPriority) {
            case "~":
                return 1;
            case ">>":
            case "<<":
            case ">>>":
                return 2;
            case "&":
                return 3;
            case "^":
                return 4;
            case "|":
                return 5;
            case "(":
            case ")":
                return 6;
            default:
                return -1;
        }
    }
}
