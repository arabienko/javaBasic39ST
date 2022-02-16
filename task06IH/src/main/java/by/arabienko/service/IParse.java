package by.arabienko.service;

import by.arabienko.bean.CompositeParts;

/**
 * Pattern: chain of responsibility.
 * Parser String in a chain Composite:
 * text - paragraph - sentences -
 * lexemes - words - symbols.
 */
public abstract class IParse {
    abstract public CompositeParts handleRequest(CompositeParts compositeParts, String str);
}
