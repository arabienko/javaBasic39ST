package by.arabienko.service.impl.parse;

import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.CompositeParts;
import by.arabienko.service.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Parse words to symbol.
 */
public class ParseWordsToSymbol extends IParse {
    private static final Logger LOGGER =
            LogManager.getLogger(ParseWordsToSymbol.class);
    @Override
    public CompositeParts handleRequest(
            CompositeParts compositeParts, String str) {
        ComponentLeaf componentLeaf;
        char[] characters = str.toCharArray();
        for (Character character : characters){
            if(character != ' ') {
                componentLeaf =
                        new ComponentLeaf(character);
                LOGGER.info("character: " + character);
                compositeParts.
                        addElement(componentLeaf);
            }
        }
          return compositeParts;
    }
}
