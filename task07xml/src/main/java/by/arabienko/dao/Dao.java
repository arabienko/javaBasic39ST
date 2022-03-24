package by.arabienko.dao;

import by.arabienko.connect.ConnectToDB;
import by.arabienko.dao.exeption.DaoException;
import by.arabienko.entity.Entity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * DAO is a class or interface that describes
 * a set of methods that will be used
 * when interacting with a table
 * or group of tables.
 * @param <K> key in table.
 * @param <T> Entity defines a common business entity
 *          from which all business entities
 *           of the system inherit
 */
public interface Dao<K, T extends Entity> {
    // Logger LOGGER = LogManager.getLogger(Dao.class);

    List<T> findAll() throws DaoException;

    T findEntityById(K id) throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean delete(K id) throws DaoException;

    boolean create(T t) throws DaoException;

    void update(T t) throws DaoException;

    default void setConnection(Connection connection) throws SQLException {
        connection = ConnectToDB.getConnection();
    }

    default void close(Statement statement) {
        try {
            if (statement!=null) {
                statement.close();
            }
        } catch (SQLException e) {
            // LOGGER.debug("Statement close error: " + e.getSQLState());
        }
    }

    default void close(Connection connection) {
        try {
            if (connection!=null) {
                connection.close(); // or connection return code to the pool
            }
        } catch (SQLException e) {
            //LOGGER.debug("Connection close error: " + e.getSQLState());
        }
    }
}
