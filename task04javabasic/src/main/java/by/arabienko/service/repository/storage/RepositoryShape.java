package by.arabienko.service.repository.storage;

/**
 * Repository interface for managing data.
 * @param <T> parametric
 */
public interface RepositoryShape<T> {
    /**
     * @param key
     * @return T by ID
     */
    T getElement(Long key);

    /**
     * Add T
     * @param t
     */
    void addElement(T t);

    /**
     * Remove T
     * @param t
     */
    void removeElement(T t);

    /**
     * Update T
     * @param t
     */
    void updateElement(T t);
}
