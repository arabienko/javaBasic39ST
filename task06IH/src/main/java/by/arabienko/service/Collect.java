package by.arabienko.service;

import by.arabienko.bean.Component;

/**
 * Interface with a method
 * that collects text from
 * the Composite template:
 * text, paragraphs, sentences,
 * lexemes, words, symbols.
 */
public abstract class Collect {
    abstract public String collect(Component composite);
}
