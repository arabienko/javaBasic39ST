package by.arabienko.service.interpreter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starting the process
 * of counting an expression
 * from reverse Polish notation.
 */
public class StartingCalculationProcess {
    private ArrayList<AbstractExpression> listExpression;
    public StartingCalculationProcess(ArrayDeque<String> arrayDeque){
        listExpression = new ArrayList<>();
        for (String lexeme : arrayDeque){
            createListExpression(lexeme);
        }
    }

    /**
     * @param lexeme
     * Organization as a list
     * of non-terminal objects.
     */
    private void createListExpression(String lexeme) {
        switch (lexeme){
            case "~":
                listExpression.add(
                        new NonterminalExpressionNOT());
                break;
            case "|":
                listExpression.add(
                        new NonterminalExpressionOR());
                break;
            case "&":
                listExpression.add(
                        new NonterminalExpressionAND());
                break;
            case "^":
                listExpression.add(
                        new NonterminalExpressionExclusiveOR());
                break;
            case "<<":
                listExpression.add(
                        new NonterminalExpressionShiftLeft());
                break;
            case ">>":
                listExpression.add(
                        new NonterminalExpressionShiftRight());
                break;
            case ">>>":
                listExpression.add(
                        new NonterminalExpressionShiftRightWithZeros());
                break;
            default:
                Scanner scan = new Scanner(lexeme);
                if (scan.hasNextInt()){
                    listExpression.add(
                            new TerminalExpressionNumber(scan.nextInt()));
                }
        }
    }

    /**
     * @return result expression.
     */
    public Number calculate(){
        Context context = new Context();
        for (AbstractExpression terminal : listExpression){
            terminal.interpret(context);
        }
        return context.popValue();
    }
}
