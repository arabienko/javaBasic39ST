package by.arabienko.service.impl.collect;

import by.arabienko.bean.Component;
import by.arabienko.bean.ExceptionBean;
import by.arabienko.bean.TypeRegex;
import by.arabienko.service.interpreter.CreateReversePolishNotation;
import by.arabienko.service.interpreter.StartingCalculationProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Iterator;

/**
 * Collect the Composite into sentences.
 */
public class CollectSentence extends CollectLexeme {
    private static final Logger LOGGER =
            LogManager.getLogger(CollectSentence.class);
    @Override
    public String collect(Component composite) {
        LOGGER.debug("Start collect from composite to sentence. "
                + composite.getClass());
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Component> iterator;
        try {
            iterator = composite.getIterator();
            String dim = composite.getSomeDelimiter();
        while (iterator.hasNext()) {
            String lexeme = super.collect(iterator.next());
            if (lexeme.matches(TypeRegex.BIT_EXPR.getRegexForSplit())) {
                CreateReversePolishNotation notation = new CreateReversePolishNotation();
                ArrayDeque<String> arrayDeque = notation.creationReverse(lexeme);
                StartingCalculationProcess process = new StartingCalculationProcess(arrayDeque);
                lexeme = String.valueOf(process.calculate());
            }
            stringBuffer.append(lexeme);
            stringBuffer.append(dim);
        }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
