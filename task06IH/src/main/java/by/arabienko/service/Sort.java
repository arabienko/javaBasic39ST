package by.arabienko.service;

import by.arabienko.bean.Component;

/**
 * Sorting text according to the task:
 * 1. sorting paragraphs by
 * the number of sentences;
 * 2. sorting words in
 * a sentence by length.
 */
public interface Sort {
    Component sort (Component component);
}
