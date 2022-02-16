package by.arabienko.service.impl.parse;

import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse lexeme to words.
 */
public class ParseLexemeToWords extends ParseWordsToSymbol {
    private static final Logger LOGGER =
            LogManager.getLogger(ParseLexemeToWords.class);
    private IParse root;

    public ParseLexemeToWords(IParse root) {
        this.root = root;
    }
    public ParseLexemeToWords() {
        this.root = null;
    }

    @Override
    public CompositeParts handleRequest(
            CompositeParts compositeParts, String str) {
        Pattern patternWords =
                Pattern.compile(TypeRegex.WORD.getRegexForSplit());
        Matcher matcherWords =
                patternWords.matcher(str);
        while (matcherWords.find()) {
            CompositeParts wordsComponent =
                    new CompositeParts(
                            TypeRegex.DELIM_SYMBOL.getRegexForSplit());
            String words =
                    matcherWords.group().trim();
            LOGGER.info("words: " + words);
            if (root==null) {
                wordsComponent =
                        super.handleRequest(wordsComponent, words);
            } else {
                root.handleRequest(wordsComponent, words);
            }
            compositeParts.
                    addElement(wordsComponent);
        }
        return compositeParts;
    }
}
