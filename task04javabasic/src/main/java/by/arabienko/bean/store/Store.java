package by.arabienko.bean.store;

import by.arabienko.bean.entity.Shape;
import java.util.List;

/**
 * An interface that describes
 * the basic rules for working
 * with storage.
 * @param <T> extends from Shape
 */
public interface Store<T extends Shape> {
    /**
     * Entity lookup method.
     * @param key ID entity
     * @return entity
     */
    Shape getItemStore(Long key);

    /**
     * Add shape to storage
     * @param shape entity
     */
    void addToStore(T shape);

    /**
     * @return copy storage
     */
    List<T> getStore();

    /**
     * The method overwrites
     * the entity that has been changed.
     * @param shape entity
     */
    void updateStore(T shape);

    /**
     *A method that removes
     * an object from storage.
     * @param shape entity
     */
    void removeInStore(T shape);
}
