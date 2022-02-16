package by.arabienko.service.impl.sort;

import by.arabienko.bean.Component;
import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.ExceptionBean;
import by.arabienko.service.Sort;
import by.arabienko.service.impl.collect.CollectWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortLexemesBySymbolCount implements Sort {
    private static final Logger LOGGER =
            LogManager.getLogger(SortLexemesBySymbolCount.class);
    @Override
    public Component sort(Component component) {
        CompositeParts compositeParts = (CompositeParts) component;
        try {
            ComponentLeaf componentLeafForSearch =
                    (ComponentLeaf) compositeParts.getElement(
                            compositeParts.getSize() - 1);
            final String toFind = String.valueOf(
                    componentLeafForSearch.getElement(0));
            component.removeElement(
                    componentLeafForSearch);
            LOGGER.debug("Sort lexemes by symbol count.- "
                    + toFind);
            Iterator<Component> iteratorParagraph =
                    compositeParts.getIterator();
            while (iteratorParagraph.hasNext()) {
                Iterator<Component> iteratorSentence =
                        iteratorParagraph.next().getIterator();
                while (iteratorSentence.hasNext()) {
                    getSortLexemesBySymbolCount(
                            (CompositeParts) iteratorSentence.next(), toFind);
                }
            }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }
        return compositeParts;
    }

    private void getSortLexemesBySymbolCount(CompositeParts next, String s) {
        final String toFind = s;
        next.getComponents().sort(((component1, component2) -> {
            if (component1 instanceof CompositeParts &&
                    component2 instanceof CompositeParts) {
                Integer compositeParts1Size = 0;
                Character word1 = null;
                Character word2 = null;
                Integer compositeParts2Size = 0;
                CompositeParts compositeParts1 =
                        (CompositeParts) component1;
                CompositeParts compositeParts2 =
                        (CompositeParts) component2;
                Iterator<Component> itCP1 =
                        compositeParts1.getIterator();
                try {
                    word1 = (Character) compositeParts1.getComponents().
                            get(0).getComponents().get(0).getElement(0);
                    word2 = (Character) compositeParts2.getComponents().
                            get(0).getComponents().get(0).getElement(0);
                } catch (ExceptionBean e) {
                    e.printStackTrace();
                }
                CollectWord collectLexeme =
                        new CollectWord();
                Pattern p = Pattern.compile(toFind,
                        Pattern.CASE_INSENSITIVE);
                while (itCP1.hasNext()) {
                    String lexeme = collectLexeme.
                            collect(itCP1.next());
                    Matcher m = p.matcher(lexeme);
                    while (m.find()) {
                        compositeParts1Size++;
                    }
                }
                Iterator<Component> itCP2 = compositeParts2.
                        getIterator();
                Pattern p2 = Pattern.compile(toFind,
                        Pattern.CASE_INSENSITIVE);
                while (itCP2.hasNext()) {
                    String lexeme = collectLexeme.
                            collect(itCP2.next());
                    Matcher m = p2.matcher(lexeme);
                    while (m.find()) {
                        compositeParts2Size++;
                    }
                }
                if (compositeParts2Size==compositeParts1Size
                        && compositeParts1Size!=0
                        && compositeParts2Size!=0) {
                    word1 = Character.toLowerCase(word1);
                    word2 = Character.toLowerCase(word2);
                    if (word1.equals(word2)) {
                        try {
                            word1 = (Character) compositeParts1.getComponents().
                                    get(0).getComponents().get(0).getElement(1);
                            word2 = (Character) compositeParts2.getComponents().
                                    get(0).getComponents().get(0).getElement(1);
                        } catch (ExceptionBean e) {
                            e.printStackTrace();
                        }
                        word1 = Character.toLowerCase(word1);
                        word2 = Character.toLowerCase(word2);
                        return word1.compareTo(word2);
                    }
                    return word1.compareTo(word2);
                }
                return compositeParts2Size.
                        compareTo(compositeParts1Size);
            }
            return 0;
        }));
    }
}
