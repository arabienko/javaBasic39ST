package by.arabienko.bean.store;

import by.arabienko.bean.entity.Registrar;
import by.arabienko.service.exception.ServiceException;

import java.util.List;

/**
 * An interface that describes
 * the basic rules for working
 * with storage.
 * @param <T> extends from Registrar
 */
public interface RegistrarStore<T extends Registrar> {
    /**
     * Entity lookup method.
     * @param key ID Registrar
     * @return entity
     */
    T getItemStore(Long key);
    /**
     * Add shape to storage
     * @param t Registrar
     */
    void addToStore(T t);
    /**
     * @return copy storage
     */
    List<T> getStore();
    /**
     * The method overwrites
     * the entity that has been changed.
     * @param t Registrar
     */
    void updateStore(T t) throws ServiceException;
    /**
     *A method that removes
     * an object from storage.
     * @param t Registrar
     */
    void removeFromStore(T t);
}
