package by.arabienko.service.impl.collect;

import by.arabienko.bean.Component;
import by.arabienko.bean.ExceptionBean;
import by.arabienko.bean.TypeRegex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;

/**
 * Collect the Composite into lexemes.
 */
public class CollectLexeme extends CollectWord {
    @Override
    public String collect(Component composite) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<Component> iterator;
        try {
            iterator = composite.getIterator();
            String dim = composite.getSomeDelimiter();
            while (iterator.hasNext()) {
                String lexeme = super.collect(iterator.next());
                stringBuffer.append(lexeme);
                stringBuffer.append(dim);
            }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
