package by.arabienko.service.interpreter;

import java.util.ArrayDeque;

/**
 * A class for storing the initial
 * numerical values of the expression,
 * as well as the results of intermediate
 * calculations and the final result.
 */
public class Context {
    private ArrayDeque<Integer> contextValue = new ArrayDeque<>();
    public Integer popValue(){
        return contextValue.pop();
    }
    public void pushValue(Integer value){
        this.contextValue.push(value);
    }
}
