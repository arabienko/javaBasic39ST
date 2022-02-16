package by.arabienko.service.impl.collect;

import by.arabienko.bean.Component;
import by.arabienko.bean.ComponentLeaf;
import by.arabienko.bean.ExceptionBean;
import by.arabienko.service.Collect;

import java.util.Iterator;

/**
 * Collect the Composite into words.
 */
public class CollectWord extends Collect {
    @Override
    public String collect(Component composite) {
        Iterator<Component> iterator;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            iterator = composite.getIterator();
            while (iterator.hasNext()) {
                ComponentLeaf character = (ComponentLeaf) iterator.next();
                Character character1 = character.getSymbol();
                stringBuffer.append(character1);
            }
        } catch (ExceptionBean e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
