package by.arabienko.service.impl.parse;

import by.arabienko.bean.CompositeParts;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.ExceptionService;
import by.arabienko.service.IParse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse text to paragraph.
 */
public class ParseTextToParagraph extends ParseParagraphToSentence {
    private static final Logger LOGGER =
            LogManager.getLogger(ParseTextToParagraph.class);
    private IParse root;

    public ParseTextToParagraph(IParse root) {
        super(root);
        this.root = root;
    }

    public ParseTextToParagraph() {
        super(null);
        this.root = null;
    }

    @Override
    public CompositeParts handleRequest(
            CompositeParts compositeParts, String text) {
        try {
            if (compositeParts == null
                    || text.length() == 0) {
                throw new ExceptionService("No data to parse.");
            }
            Pattern patternParagraph =
                    Pattern.compile(TypeRegex.PARAGRAPH.getRegexForSplit());
            Matcher matcherParagraph =
                    patternParagraph.matcher(text);
            while (matcherParagraph.find()) {
                CompositeParts paragraphComponent =
                        new CompositeParts(
                                TypeRegex.DELIM_SENTENCE.getRegexForSplit());
                String paragraph =
                        matcherParagraph.group().trim();
                LOGGER.info("Paragraph: " + paragraph);
                if (root==null) {
                    paragraphComponent =
                            super.handleRequest(paragraphComponent, paragraph);
                } else {
                    root.handleRequest(paragraphComponent, paragraph);
                }
                compositeParts.
                        addElement(paragraphComponent);
            }
        } catch (ExceptionService e) {
            e.printStackTrace();
        }
        return compositeParts;
    }
}
