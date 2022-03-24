package by.arabienko.dao.daologic;

import by.arabienko.dao.Dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EntityTransaction {
    private Connection connection;

    public void init(Dao dao) {
        if (connection==null) {
// connection = // code -> create connection or take connection from pool
        }
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            dao.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void end() {
// code -> check of null connection
// code -> return connection to pool or closing
        connection = null;
    }

    public void commit() {
        try {
            connection.commit();
        } catch (SQLException e) {
// log
        }
    }

    public void rollback() {
        try {
            connection.rollback();
        } catch (SQLException e) {
// log
        }
    }
}
