package by.arabienko.service.interpreter;

public class NonterminalExpressionShiftLeft extends AbstractExpression{
    @Override
    public void interpret(Context context) {
        int arg1 = context.popValue();
        int arg2 = context.popValue();
        context.pushValue(arg1 << arg2);
    }
}
