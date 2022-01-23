package by.arabienko.bean.observer;

import by.arabienko.bean.entity.ConeShape;

import java.util.EventObject;

/**
 * Class Event prototype
 */
public class ConeShapeEvent extends EventObject {
    /**
     * Creates an event prototype.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ConeShapeEvent(ConeShape source) {
        super(source);
    }
    @Override
    public ConeShape getSource() {
        return (ConeShape)super.getSource();
    }
}
