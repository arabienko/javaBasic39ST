package by.arabienko.bean.observer;

/**
 * Observer interface.
 */
public interface Observer {
    /**
     * @param event Event Reacting Method
     */
    void handleEvent(ConeShapeEvent event);
}
