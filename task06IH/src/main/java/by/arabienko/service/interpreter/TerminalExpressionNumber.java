package by.arabienko.service.interpreter;

public class TerminalExpressionNumber extends AbstractExpression {
    private int number;

    public TerminalExpressionNumber(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
