package by.arabienko.service.impl.parse;

import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse sentences to lexemes.
 */
public class ParseSentenceToLexeme extends ParseLexemeToWords {
    private static final Logger LOGGER =
            LogManager.getLogger(ParseSentenceToLexeme.class);
    private IParse root;

    public ParseSentenceToLexeme(IParse root) {
        super(root);
        this.root = root;
    }
    public ParseSentenceToLexeme() {
        super(null);
        this.root = null;
    }


    @Override
    public CompositeParts handleRequest(
            CompositeParts compositeParts, String str) {
        Pattern patternLexeme =
                Pattern.compile(TypeRegex.LEXEME.getRegexForSplit());
        Matcher matcherLexeme =
                patternLexeme.matcher(str);
        while (matcherLexeme.find()) {
            CompositeParts lexemeComponent =
                    new CompositeParts(
                            TypeRegex.DELIM_SYMBOL.getRegexForSplit());
            String lexeme =
                    matcherLexeme.group().trim();
            LOGGER.info("lexeme: " + lexeme);
            if (root==null) {
            lexemeComponent =
                    super.handleRequest(lexemeComponent, lexeme);
            } else {
                root.handleRequest(lexemeComponent, lexeme);
            }
            compositeParts.
                    addElement(lexemeComponent);
        }
        return compositeParts;
    }
}
