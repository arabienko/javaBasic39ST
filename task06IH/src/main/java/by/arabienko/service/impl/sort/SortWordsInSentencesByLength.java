package by.arabienko.service.impl.sort;

import by.arabienko.bean.*;
import by.arabienko.service.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

public class SortWordsInSentencesByLength implements Sort {
    private static final Logger LOGGER =
            LogManager.getLogger(SortWordsInSentencesByLength.class);

    @Override
    public Component sort(Component component) {
        CompositeParts compositeParts =
                (CompositeParts) component;
        Iterator<Component> iteratorParagraph =
                compositeParts.getIterator();
        try {
            while (iteratorParagraph.hasNext()) {
                Iterator<Component> iteratorSentence =
                        iteratorParagraph.next().getIterator();
                while (iteratorSentence.hasNext()) {
                    getSortedWordsByNumberOfLetters(
                            (CompositeParts) iteratorSentence.next());
                }
            }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }

        return compositeParts;
    }

    private static void getSortedWordsByNumberOfLetters(CompositeParts composite) {
        LOGGER.debug("Sort words in sentences by length.");
        composite.getComponents().sort(
                (component1, component2) -> {
                    if (component1 instanceof CompositeParts &&
                            component2 instanceof CompositeParts) {
                        try {
                        CompositeParts compositeParts1 =
                                (CompositeParts) component1.getElement(0);
                        CompositeParts compositeParts2 =
                                (CompositeParts) component2.getElement(0);
                        Integer compositeParts1Size =
                                compositeParts1.getSize();
                        Integer compositeParts2Size =
                                compositeParts2.getSize();
                        return compositeParts1Size.
                                compareTo(compositeParts2Size);
                        } catch (ExceptionBean e) {
                            e.printStackTrace();
                        }
                    }
                    return 0;
                });
    }
}
