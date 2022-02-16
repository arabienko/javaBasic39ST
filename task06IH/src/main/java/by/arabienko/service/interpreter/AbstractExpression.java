package by.arabienko.service.interpreter;

/**
 * A class to retrieve
 * from the Context object,
 * perform an action,
 * and write the result
 * to the same object.
 * The following operations:
 * <<(shift left), >>(shift right),
 * >>>(shift right with zeros), ~(NOT),
 * ^(exclusive OR), |(OR), &(AND).
 */
public abstract class AbstractExpression {
    public abstract void interpret(Context context);
}
