package by.arabienko.service.impl.collect;

import by.arabienko.bean.Component;
import by.arabienko.bean.ExceptionBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

/**
 * Collect the Composite into paragraphs.
 */
public class CollectParagraph extends CollectSentence {
    private static final Logger LOGGER =
            LogManager.getLogger(CollectParagraph.class);
    @Override
    public String collect(Component composite) {
        LOGGER.debug("Start collect from composite to paragraph. "
                + composite.getClass());
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Component> iterator;
        try {
            iterator = composite.getIterator();
            String dim = composite.getSomeDelimiter();
            while (iterator.hasNext()) {
                stringBuffer.append(super.collect(iterator.next()));
                stringBuffer.append(dim);
            }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
