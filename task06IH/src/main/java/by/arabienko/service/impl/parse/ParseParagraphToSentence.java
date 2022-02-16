package by.arabienko.service.impl.parse;

import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse paragraphs to sentences.
 */
public class ParseParagraphToSentence extends ParseSentenceToLexeme {
    private static final Logger LOGGER =
            LogManager.getLogger(ParseParagraphToSentence.class);
    private IParse root;

    public ParseParagraphToSentence(IParse root) {
        super(root);
        this.root = root;
    }
    public ParseParagraphToSentence() {
        super(null);
        this.root = null;
    }

    @Override
    public CompositeParts handleRequest(
            CompositeParts compositeParts, String str) {
        Pattern patternSentence =
                Pattern.compile(TypeRegex.SENTENCE.getRegexForSplit());
        Matcher matcherSentence =
                patternSentence.matcher(str);
        while (matcherSentence.find()) {
            CompositeParts sentenceComponent =
                    new CompositeParts(
                            TypeRegex.DELIM_SENTENCE.getRegexForSplit());
            String sentence =
                    matcherSentence.group().trim();
            LOGGER.info("sentence: " + sentence);
            if (root==null) {
            sentenceComponent = super
                    .handleRequest(sentenceComponent, sentence);
            } else {
                root.handleRequest(sentenceComponent, sentence);
            }
            compositeParts
                    .addElement(sentenceComponent);
        }
        return compositeParts;
    }
}
