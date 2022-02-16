package by.arabienko.service.impl.sort;

import by.arabienko.bean.Component;
import by.arabienko.bean.CompositeParts;
import by.arabienko.service.Sort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Sort paragraphs by number of sentences.
 */
public class SortParagraphsByNumberOfSentences implements Sort {
    private static final Logger LOGGER =
            LogManager.getLogger(SortParagraphsByNumberOfSentences.class);

    @Override
    public Component sort(Component component) {
        LOGGER.debug("Sort paragraphs by number of sentences.");
        CompositeParts compositeParts = (CompositeParts) component;
        compositeParts.getComponents().sort(
                (component1, component2) -> {
            if (component1 instanceof CompositeParts &&
                    component2 instanceof CompositeParts) {
                CompositeParts compositeParts1 =
                        (CompositeParts) component1;
                CompositeParts compositeParts2 =
                        (CompositeParts) component2;
                Integer compositeParts1Size =
                        compositeParts1.getSize();
                Integer compositeParts2Size =
                        compositeParts2.getSize();
                return compositeParts1Size.
                        compareTo(compositeParts2Size);
            }
            return 0;
        });
        return compositeParts;
    }
}
