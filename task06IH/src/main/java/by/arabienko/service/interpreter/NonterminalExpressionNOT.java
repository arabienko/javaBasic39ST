package by.arabienko.service.interpreter;

public class NonterminalExpressionNOT extends AbstractExpression{
    @Override
    public void interpret(Context context) {
        context.pushValue(~context.popValue());
    }
}
